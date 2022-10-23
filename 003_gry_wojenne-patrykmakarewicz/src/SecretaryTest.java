import org.junit.*;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Files;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.rules.ExternalResource;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

public class SecretaryTest {

    private Path workingDir;

    @Before
    public void init() {
        this.workingDir = Path.of("");
    }
    @Test
    public void updateTest() throws IOException {
        Private soldier = new Private();
        List<Soldier> army = new ArrayList<Soldier>();
        army.add(soldier);
        General general = new General(army, 100);
        Secretary secretary = new Secretary(general);
        general.attach(secretary);
        general.buy(1);
        Path file = this.workingDir.resolve("logs.txt");
        String content = Files.readString(file);
        assertThat(content, containsString("bought"));
    }

}
