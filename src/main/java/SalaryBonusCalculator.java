import java.util.Scanner;

public class SalaryBonusCalculator {
  public static final double SALES_REP_BONUS_PERCENT = 0.1;
  public static final double SALES_REP_LIMIT = 10000.0;
  public static final double ENGINEER_BONUS_PER_UNIT = 20.0;
  public static final double TECHNICIAN_BONUS_AMT = 0.2;
  public static final int TECHNICIAN_BONUS_LIMIT_FULLTIME = 700;
  public static final int TECHNICIAN_BONUS_LIMIT_PARTTIME = 300;

  public static void main(String[] args) {
    SalaryBonusCalculator bonusCalculator = new SalaryBonusCalculator();
    bonusCalculator.getEmployeeDetails();
  }

  void getEmployeeDetails() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter job description: ");
    String job = scanner.nextLine();
    double bonus = 0;

    switch (job) {
      case "Sales":
        double sales = querySales(scanner);
        bonus = calculateBonus(sales);
        break;
      case "Engineer":
        int unitsSold = querySoldUnits(scanner);
        bonus = calculateBonus(unitsSold);
        break;
      case "Technician":
        int partsAssembled = queryPartsAssembled(scanner);
        int empType = queryEmployeeStatus(scanner);
        bonus = calculateBonus(partsAssembled, empType);
        break;
      default:
        System.out.print("Error! Bad input.");
    }

    System.out.println("Your bonus for this month is: " + bonus);
  }

  double calculateBonus(double salesTotal) {
    if (salesTotal >= SALES_REP_LIMIT) {
      return salesTotal * SALES_REP_BONUS_PERCENT;
    }
    return 0;
  }

  double calculateBonus(int unitsSold) {
    return unitsSold * ENGINEER_BONUS_PER_UNIT;
  }

  double calculateBonus(int partsAssembled, int employeeType) {
    int bonusThreshold = getTechnicianBonusThreshold(employeeType);

    if (partsAssembled >= bonusThreshold) {
      return TECHNICIAN_BONUS_AMT * partsAssembled;
    }
    return 0;
  }

  private int getTechnicianBonusThreshold(int employeeType) {
    if (employeeType == 1) {
      return TECHNICIAN_BONUS_LIMIT_FULLTIME;
    } else if (employeeType == 0) {
      return TECHNICIAN_BONUS_LIMIT_PARTTIME;
    }
    return 0;
  }


  private int queryPartsAssembled(Scanner scanner) {
    System.out.print("Enter number of parts completed: ");
    return scanner.nextInt();
  }

  private int queryEmployeeStatus(Scanner scanner) {
    System.out.print("Are you working Full-time (1) or Part-Time (2)? ");
    return scanner.nextInt();
  }

  private int querySoldUnits(Scanner scanner) {
    System.out.print("Enter number of units sold: ");
    return scanner.nextInt();
  }

  double querySales (Scanner scanner) {
    System.out.print("Enter your sales amount: ");
    return scanner.nextDouble();
  }
}


