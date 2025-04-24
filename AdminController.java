@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private FriendService friendService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private AnalyticsService analyticsService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminLoginDTO dto) {
        return ResponseEntity.ok("Logged in");
    }

    @GetMapping("/dashboard")
    public DashboardData getDashboard() {
        return analyticsService.getDashboardStats();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/users/{id}")
    public User editUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.getAllPosts();
    }

    @PutMapping("/posts/{id}")
    public Post editPost(@PathVariable Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @GetMapping("/friends/requests")
    public List<FriendRequest> viewFriendRequests() {
        return friendService.getPendingRequests();
    }

    @PostMapping("/friends/requests/{id}/accept")
    public void acceptRequest(@PathVariable Long id) {
        friendService.acceptRequest(id);
    }

    @PostMapping("/friends/requests/{id}/deny")
    public void denyRequest(@PathVariable Long id) {
        friendService.denyRequest(id);
    }

    @GetMapping("/friends")
    public Map<Long, List<User>> viewFriendsList() {
        return friendService.getAllFriendLists();
    }

    @GetMapping("/reports")
    public List<Report> viewReports() {
        return reportService.getAllReports();
    }

    @PostMapping("/reports/{id}/action")
    public void takeAction(@PathVariable Long id, @RequestParam String action) {
        reportService.handleReport(id, action);
    }

    @GetMapping("/analytics")
    public AnalyticsData getAnalytics() {
        return analyticsService.getAnalytics();
    }
}
