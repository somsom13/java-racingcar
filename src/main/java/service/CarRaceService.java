package service;

import java.util.List;
import java.util.Map;

public interface CarRaceService {

    Map<String, Integer> saveCars(List<String> names);

}