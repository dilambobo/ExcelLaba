package com.example.excellab;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;

import java.util.LinkedHashMap;

public class Calculation {

    private static final LinkedHashMap<String, Double[]> linkedHashMap = new LinkedHashMap<>();

    public LinkedHashMap getCalculationResult() {
        return linkedHashMap;
    }

    // 	Среднее геометрическое
    private static void geometricMean(double[][] arr) {
        Double[] geometricMean = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            geometricMean[i] = StatUtils.geometricMean(arr[i]);
        }
        linkedHashMap.put("Среднее геометрическое", geometricMean);
    }

    // Среднее арифметическое
    private static void arithmeticMean(double[][] arr) {
        Double[] arithmeticMean = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arithmeticMean[i] = StatUtils.mean(arr[i]);
        }
        linkedHashMap.put("Среднее арифметическое", arithmeticMean);
    }

    //  Оценка стандартного отклонения
    private static void standardDeviation(double[][] arr) {
        Double[] standardDeviation = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            standardDeviation[i] = Math.sqrt(StatUtils.variance(arr[i]));
        }
        linkedHashMap.put("Стандартное отклонение", standardDeviation);
    }

    // 	Размах
    private static void sampleSize(double[][] arr) {
        Double[] sampleSize = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sampleSize[i] = StatUtils.max(arr[i]) - StatUtils.min(arr[i]);
        }
        linkedHashMap.put("Размах", sampleSize);
    }

    // Коэффициенты ковариации для всех пар случайных чисел
    private static void covariance(double[][] arr) {
        Double[] covariance = new Double[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            covariance[i] = new Covariance().covariance(arr[i], arr[i + 1]);
        }
        covariance[arr.length - 1] = new Covariance().covariance(arr[arr.length - 1], arr[0]);
        linkedHashMap.put("Коэффициенты ковариации", covariance);
    }

    // Количество элементов в каждой выборке
    private static void amount(double[][] arr) {
        Double[] amount = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            amount[i] = (double) arr[i].length;
        }
        linkedHashMap.put("Количество элементов", amount);
    }

    // Коэффициент вариации для каждой выборки
    private static void variation(double[][] arr) {
        Double[] variation = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            variation[i] = Math.sqrt(StatUtils.variance(arr[i])) / Math.abs(StatUtils.mean(arr[i]));
        }
        linkedHashMap.put("Коэффициент вариации", variation);
    }

    // Доверительный интервал для мат. ожидания
    private static void minusInterval(double[][] arr) {
        Double[] interval = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            interval[i] = StatUtils.mean(arr[i]) - (new TDistribution(arr[i].length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(arr[i]))) / Math.sqrt(arr[i].length);
        }
        linkedHashMap.put("-Доверительный интервал", interval);
    }

    private static void plusInterval(double[][] arr) {
        Double[] interval = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            interval[i] = StatUtils.mean(arr[i]) + (new TDistribution(arr[i].length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(arr[i]))) / Math.sqrt(arr[i].length);
        }
        linkedHashMap.put("+Доверительный интервал", interval);
    }

    // Оценка дисперсии для каждой выборки
    private static void dispersion(double[][] arr) {
        Double[] dispersion = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dispersion[i] = StatUtils.variance(arr[i]);
        }
        linkedHashMap.put("Оценка дисперсии", dispersion);
    }

    // Максимумы для каждой выборки
    private static void max(double[][] arr) {
        Double[] max = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            max[i] = StatUtils.max(arr[i]);
        }
        linkedHashMap.put("Максимумы", max);
    }

    // Минимумы для каждой выборки
    private static void min(double[][] arr) {
        Double[] min = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            min[i] = StatUtils.min(arr[i]);
        }
        linkedHashMap.put("Минимумы", min);
    }

    public static void makeCalculation(double[][] arr) {
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
