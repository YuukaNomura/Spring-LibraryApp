package kakeibo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kakeibo.entity.Budget;
import kakeibo.entity.CalcForm;
import kakeibo.entity.Category;
import kakeibo.entity.Performance;
import kakeibo.entity.PerformanceForm;
import kakeibo.entity.ResultForm;
import kakeibo.entity.User;
import kakeibo.service.BudgetService;
import kakeibo.service.CategoryService;
import kakeibo.service.PerformanceService;
import kakeibo.service.UserService;



@Controller
public class KakeiboController {

	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PerformanceService performanceService;
	@Autowired
	private BudgetService budgetService;
	@Autowired
	private HttpSession session;
	
	
	//ログアウト
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "login";
	}
	
	
	//ログイン機能
	@GetMapping("/")
	public String loginGet() {
		return "login";
	}

	@PostMapping("/login")
	public String loginPost(@ModelAttribute User user, Model model) {
		
		int userID = userService.checkLogin(user);

		if (userID != 0) {
			
			ArrayList<Category> categoryList = new ArrayList<Category>();
			categoryList = categoryService.getCategory();
			model.addAttribute("categoryList", categoryList);
			
			session.setAttribute("userID", userID);
			session.setAttribute("categoryList", categoryList);

			return "input";
			
		} else {
			return "login";
		}
	}
	
	
	
	//登録機能
	@GetMapping("/input")
	public String inputGet(Model model) {
		
		ArrayList<Category> categoryList = new ArrayList<Category>();
		categoryList = (ArrayList<Category>) session.getAttribute("categoryList");
		model.addAttribute("categoryList", categoryList);
		
		return "input";
	}
	
	@PostMapping("/input")
	public String inputPost(@ModelAttribute Performance performance) {
		
		performance.setUserID((int) session.getAttribute("userID"));

		if (performanceService.inputPerformance(performance)) {
			return "OK";
			
		} else {
			return "NG";
		}
	}
	
	
	
	//検索機能
	@GetMapping("/search")
	public String searchGet() {
		return "search";
	}
	
	@PostMapping("/search")
	public String searchPost(@RequestParam("date")String date, Model model) {

		int userID = (int) session.getAttribute("userID");
		ArrayList<Category> categoryList = new ArrayList<Category>();
		categoryList = (ArrayList<Category>) session.getAttribute("categoryList");
		
		List<PerformanceForm> performanceForm = performanceService.getPerformance(userID, date, categoryList);
		model.addAttribute("performanceForm", performanceForm);
		
		return "searchResult";	
	}
	
	
	
	//変更機能
	@PostMapping("/change1")
	public String Change1Post(@RequestParam("performanceID")int performanceID, Model model) {

		Performance p = performanceService.getPerformanceById(performanceID);
		
		ArrayList<Category> categoryList = new ArrayList<Category>();
		categoryList = (ArrayList<Category>) session.getAttribute("categoryList");

		if(p!=null) {
			
			model.addAttribute("performance", p);
			model.addAttribute("categoryList", categoryList);
			
			return "change";
		} else {
			return "NG";
		}
	}
	
	@PostMapping("/change2")
	public String Change2Post(@ModelAttribute Performance performance) {

		if (performanceService.changePerformance(performance)) {
			return "OK";
		} else {
			return "NG";
		}
	}
	
	
	
	//削除機能
	@PostMapping("/delete")
	public String DeletePost(@RequestParam("performanceID")int performanceID) {

		if (performanceService.deletePerformance(performanceID)) {
			return "OK";
		} else {
			return "NG";
		}
	}
	
	
	
	//目標額登録機能
	@GetMapping("/inputBudget")
	public String inputBudgetGet() {
		return "inputBudget";
	}
	
	@PostMapping("/inputBudget")
	public String inputPost(@RequestParam("amount")int[] amounts, @RequestParam("date")String date) {

		int userID = (int) session.getAttribute("userID");

		if (budgetService.inputBudget(userID, amounts, date)) {
			return "OK";
			
		} else {
			return "NG";
		}
	}
	
	
	
	//目標額検索機能
	@GetMapping("/searchBudget")
	public String searchBudgetGet() {
		return "searchBudget";
	}
	
	@PostMapping("/searchBudget")
	public String searchPost(@ModelAttribute Budget budget, Model model) {
		
		String date = budget.getDate();

		int userID = (int) session.getAttribute("userID");
		ArrayList<Category> categoryList = new ArrayList<Category>();
		categoryList = (ArrayList<Category>) session.getAttribute("categoryList");

		ArrayList<Performance> performanceList = performanceService.getPerformanceGroupByCategory(userID, budget.getDate());
		List<Budget> budgetList = budgetService.getBudget(budget, userID);
		CalcForm cf = budgetService.calc(budgetList, performanceList);
		List<ResultForm> bf = budgetService.x(budgetList, performanceList, categoryList);
		
		model.addAttribute("date", date);
		model.addAttribute("cf", cf);
		model.addAttribute("bf", bf);

		return "searchResultBudget";
	}
}
