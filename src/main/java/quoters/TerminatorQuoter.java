package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Profiling
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    @Autowired
    private ApplicationContext context;

    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase 1");
        System.out.println(repeat);
    }


    @PostConstruct
    public void init() {
        System.out.println("Phase 2");
        System.out.println(repeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    @PostProxy
    public void sayQuote() {
        System.out.println("3 phase");
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);

        }
    }
}
