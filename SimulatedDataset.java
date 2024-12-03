import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

class Car {
    private String carName;
    private String carDescription;
    private int carNo;

    public Car(String carName, String carDescription, int carNo) {
        this.carName = carName;
        this.carDescription = carDescription;
        this.carNo = carNo;
    }

    @Override
   @Override
public String toString() {
    return String.format("Car{carName='%s', carDescription='%s', carNo=%d}", carName, carDescription, carNo);
}


    public String getCarName() {
        return carName;
    }

    public int getCarNo() {
        return carNo;
    }
}

public class SimulatedDataset {
    public static void main(String[] args) {
        Set<String> uniqueCarNames = new HashSet<>();
        List<Car> carList = new ArrayList<>();
        Random random = new Random();

        while (carList.size() < 10) {
            String carName = "Car" + random.nextInt(100);
            String carDescription = "Description of " + carName;
            int carNo = random.nextInt(1000);

            if (uniqueCarNames.add(carName)) {
                carList.add(new Car(carName, carDescription, carNo));
            }
        }

        for (Car car : carList) {
            System.out.println(car);
        }
    }
}
