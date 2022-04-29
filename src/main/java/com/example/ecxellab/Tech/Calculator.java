package com.example.ecxellab.Tech;

import java.util.LinkedHashMap;
import org.apache.*;
public class Calculator {
    private final LinkedHashMap<String, Double[]> linkedHashMap = new LinkedHashMap<>();

    public LinkedHashMap getCalculationResult() {
        return linkedHashMap;
    }

    // 	Среднее геометрическое
    private void geometricMean(double[][] arr) {
        Double[] geometricMean = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            geometricMean[i] = StatUtils.geometricMean(arr[i]);
        }
        linkedHashMap.put("Среднее геометрическое", geometricMean);
    }

    // Среднее арифметическое
    private void arithmeticMean(double[][] arr) {
        Double[] arithmeticMean = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arithmeticMean[i] = StatUtils.mean(arr[i]);
        }
        linkedHashMap.put("Среднее арифметическое", arithmeticMean);
    }

    //  Оценка стандартного отклонения
    private void standardDeviation(double[][] arr) {
        Double[] standardDeviation = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            standardDeviation[i] = Math.sqrt(StatUtils.variance(arr[i]));
        }
        linkedHashMap.put("Стандартное отклонение", standardDeviation);
    }

    // 	Размах
    private void sampleSize(double[][] arr) {
        Double[] sampleSize = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sampleSize[i] = StatUtils.max(arr[i]) - StatUtils.min(arr[i]);
        }
        linkedHashMap.put("Размах", sampleSize);
    }

    // Коэффициенты ковариации для всех пар случайных чисел
    private void covariance(double[][] arr) {
        Double[] covariance = new Double[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            covariance[i] = new Covariance().covariance(arr[i], arr[i + 1]);
        }
        covariance[arr.length - 1] = new Covariance().covariance(arr[arr.length - 1], arr[0]);
        linkedHashMap.put("Коэффициенты ковариации", covariance);
    }

    // Количество элементов в каждой выборке
    private void amount(double[][] arr) {
        Double[] amount = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            amount[i] = (double) arr[i].length;
        }
        linkedHashMap.put("Количество элементов", amount);
    }

    // Коэффициент вариации для каждой выборки
    private void variation(double[][] arr) {
        Double[] variation = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            variation[i] = Math.sqrt(StatUtils.variance(arr[i])) / Math.abs(StatUtils.mean(arr[i]));
        }
        linkedHashMap.put("Коэффициент вариации", variation);
    }

    // Доверительный интервал для мат. ожидания
    private void minusInterval(double[][] arr) {
        Double[] interval = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            interval[i] = StatUtils.mean(arr[i]) - (new TDistribution(arr[i].length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(arr[i]))) / Math.sqrt(arr[i].length);
        }
        linkedHashMap.put("-Доверительный интервал", interval);
    }

    private void plusInterval(double[][] arr) {
        Double[] interval = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            interval[i] = StatUtils.mean(arr[i]) + (new TDistribution(arr[i].length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(arr[i]))) / Math.sqrt(arr[i].length);
        }
        linkedHashMap.put("+Доверительный интервал", interval);
    }

    // Оценка дисперсии для каждой выборки
    private void dispersion(double[][] arr) {
        Double[] dispersion = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dispersion[i] = StatUtils.variance(arr[i]);
        }
        linkedHashMap.put("Оценка дисперсии", dispersion);
    }

    // Максимумы для каждой выборки
    private void max(double[][] arr) {
        Double[] max = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            max[i] = StatUtils.max(arr[i]);
        }
        linkedHashMap.put("Максимумы", max);
    }

    // Минимумы для каждой выборки
    private void min(double[][] arr) {
        Double[] min = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            min[i] = StatUtils.min(arr[i]);
        }
        linkedHashMap.put("Минимумы", min);
    }

    public void makeCalculation(double[][] arr) {
        geometricMean(arr);
        arithmeticMean(arr);
        standardDeviation(arr);
        sampleSize(arr);
        covariance(arr);
        amount(arr);
        variation(arr);
        minusInterval(arr);
        plusInterval(arr);
        dispersion(arr);
        max(arr);
        min(arr);
    }
}
