import com.sun.xml.internal.ws.server.provider.AsyncProviderInvokerTube;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    static Scanner scan = new Scanner(System.in);
    private static String x;

    public static void main(String[] args) {
      //  GiftBox box = new GiftBox();


        ArrayList<String> BoxN = new ArrayList<String>();
        ArrayList<Double> BoxC = new ArrayList<Double>();
        ArrayList<Double> BoxW = new ArrayList<Double>();

        String nC = "  ";

        double pC = 0;
        double wC = 0;
        int vibor = 3;
        int s2;
        while (vibor != 0) {
            System.out.println("Выберите действие: ");
            System.out.println("1 - Добавить сладость, 2 - Удалить сладость из подарка, 0 - Выход (Итого)");
            int sl = scan.nextInt();
            if (sl == 1) {
                String nc1 = scan.nextLine(); //для чистки строки nameS
                System.out.println("Введите название: ");
                nC = scan.nextLine();
                System.out.println("Введите цену: ");
                pC = scan.nextInt();
                System.out.println("Введите вес: ");
                wC = scan.nextInt();
                BoxN.add(nC);
                BoxC.add(pC);
                BoxW.add(wC);
            }

            if (sl == 2) {
                s2 = BoxN.size();
                while (s2 >= BoxN.size())
                {
                    System.out.println("Введите уникальный номер для удаления сладости: ");
                    s2 = scan.nextInt();
                    if (s2 > (BoxN.size()-1)) {
                        System.out.println("Уникальный номер должен быть от 0 до " + (BoxN.size()-1));
                    }
                }
                boolean vopros = true;
                System.out.print("Вы действительно хотите удалить эту сладость? (true/false)");
                vopros = scan.nextBoolean();
                if (vopros == false)
                {}
                else {
                    BoxN.remove(s2);
                    BoxC.remove(s2);
                    BoxW.remove(s2);
                }
            }
            System.out.printf("В подарке %d находится сладостей \n", BoxN.size());
            vibor = sl;
        }
        System.out.println("Проверка выхода: ");
        System.out.println("------------------------------------------------------------------------ ");
        Object[] sweetsN = BoxN.toArray();
        Object[] sweetsC = BoxC.toArray();
        Object[] sweetsW = BoxW.toArray();
        int a = 0;
        double totalWeight = 0;
        double totalPrice = 0;
        for (Object name : sweetsN) {
            Double box1C = BoxC.get(a);
            Double box1W = BoxW.get(a);
            System.out.print("Наименование сладости: ");
            System.out.print(name);
            System.out.print(" Цена сладости: ");
            System.out.print(box1C);
            System.out.print(" Вес сладости: ");
            System.out.println(box1W);
            totalPrice += box1C;
            totalWeight += box1W;
            a++;
        }
        System.out.printf("В подарке находится сладостей " + BoxN.size() + " Общей ценой = " + totalPrice + " Общий вес = " + totalWeight + "\n");
    }
}
