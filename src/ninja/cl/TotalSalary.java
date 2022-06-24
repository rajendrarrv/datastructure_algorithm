package ninja.cl;

import static utils.MathUtils.percentage;
import static utils.MathUtils.roundOff;

public class TotalSalary {

    public double netSalary(int basic, char grade) {
        double hra = percentage(basic, 20);
        double da = percentage(basic, 50);
        double allow = 0;
        double pf = percentage(basic, 11);
        switch (grade) {
            case 'A':
                allow = 1700;
                break;
            case 'B':
                allow = 1500;
                break;
            case 'C':
                allow = 1300;
                break;
        }
        return roundOff(basic + hra + da + allow - pf, 2);
    }


}
