package geekbrain;



public class Main {

    public static void main(String[] args) {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] arr0 = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        methodOne(arr);
        long b = System.currentTimeMillis();
        System.out.println("Время метода 1: " + (b - a));
        long a2 = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        long breakdown = System.currentTimeMillis();
        methodTwo(arr1, arr2, h);
        long time = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr0, 0, h);
        System.arraycopy(arr2, 0, arr0, h, h);
        long montage = System.currentTimeMillis();
        System.out.println("Время разбивки массива: " + (breakdown - a2));
        System.out.println("Время просчёта массивов : " + (time - breakdown));
        System.out.println("Время склейки массивов: " + (montage - time));
        System.out.println("Время метода 2: " + (montage - a2));
        System.out.println(arr.equals(arr0));
        //System.out.println(arr[size-1]);
        //System.out.println(arr0[size-1]);
    }

    private static void methodOne(float[] arr) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void methodTwo(float[] arr1, float[] arr2, int h) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int y = 0; y < arr2.length; y++) {
                    arr2[y] = (float) (arr2[y] * Math.sin(0.2f + (y+h) / 5) * Math.cos(0.2f + (y+h) / 5) * Math.cos(0.4f + (y+h) / 2));
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }




