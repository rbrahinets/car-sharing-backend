package com.carsharing.utility;

import com.carsharing.db.DatabaseTemplate;
import com.carsharing.models.Car;
import com.carsharing.repositories.CarRepository;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ImageUtility {
    public void setImagesToDatabase(List<String> images) throws Exception {
        CarRepository carRepository = new CarRepository(DatabaseTemplate.getJdbcTemplate());
        for (int i = 0; i < images.size(); i++) {
            Optional<Car> car = carRepository.findById(i + 1);
            if (car.isPresent() && (car.get().getImage() == null)) {
                byte[] byteImage = ImageUtility.imageToBytes(new File(images.get(i)));
                carRepository.saveImageForCar(byteImage, i + 1);
            }
        }
    }

    public static byte[] imageToBytes(File file) throws IOException {
        try (
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream()
        ) {
            byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                bos.write(buf, 0, readNum);
            }

            return bos.toByteArray();
        }
    }
}
