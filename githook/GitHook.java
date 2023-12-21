import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GitHook {
    // pre-commit sample
    private static final String PRE_COMMIT_SAMPLE_FILE = ".git/hooks/pre-commit.sample";
    private static final String PRE_COMMIT_EXEC_FILE = ".git/hooks/pre-commit";
    private static final List<String> PRE_COMMIT_HOOKS = List.of("mvn test");

    private static final List<GitHookItem> REGISTER_HOOKS =
            List.of(new GitHookItem(PRE_COMMIT_SAMPLE_FILE, PRE_COMMIT_EXEC_FILE, PRE_COMMIT_HOOKS));

    public static void main(String[] args) {
        REGISTER_HOOKS.forEach(GitHookItem::register);
    }

    static final class GitHookItem {
        private final String SAMPLE_FILE;
        private final String EXEC_FILE;
        private final List<String> HOOKS;

        GitHookItem(String sample_file, String exec_file, List<String> hooks) {
            SAMPLE_FILE = sample_file;
            EXEC_FILE = exec_file;
            HOOKS = hooks;
        }

        public void register() {
            File file = new File(SAMPLE_FILE);

            if (file.exists()) {
                File newFile = new File(EXEC_FILE);

                if (file.renameTo(newFile)) {
                    try (FileWriter writer = new FileWriter(newFile)) {
                        HOOKS.forEach(hook -> {
                            try {
                                writer.write("\n");
                                writer.write(hook);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
//                        System.out.println("GitHook file renamed and content written successfully.");
                    } catch (IOException e) {
//                        System.out.println("Failed to write content to the hook file.");
                    }
                } else {
                    // field to rename hook file
//                    System.out.println("Failed to rename the hook file.");
                }
            } else {
                // already changed, do nothing
//                System.out.println("Already done the hook file.");
            }
        }
    }
}