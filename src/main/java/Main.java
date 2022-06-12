import csv.MarginCsv;
import csv.ProductCsv;
import decorator.Decorator;
import decorator.DecoratorDiscount;
import decorator.DecoratorMargin;
import model.Margins;
import model.Products;

import java.io.IOException;
import java.util.Scanner;

/*
Разработать приложение, формирующее прайс-лист товаров некоторого магазина.
Список товаров (категория, название, закупочная стоимость) считывается из некоторого файла (формат можно выбрать произвольным образом).
Также для каждой категории товаров в отдельном файле задаётся процент наценки, если для некоторой категории процент наценки не указан,
то принимается наценка по умолчанию (заданная в том же файле). Ещё в одном файле определяются скидки на некоторые конкретные товары,
при чём на некоторые товары скидка определяется в процентах, для некоторых - в рублях. Приложение должно вывести
все товары с окончательной ценой.
Расчет наценок и скидок реализовать через шаблон проектирования «Decorator».
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите: 1 - товары с базовой ценой, 2 - товары с наценкой, 3 - товары с наценкой и скидкой");
        int choice = scanner.nextInt();
        Decorator decorator = new Decorator();
        while(true) {
            switch (choice) {
                case 1:
                    decorator = new Decorator();
                    break;
                case 2:
                    decorator = new DecoratorMargin();
                    break;
                case 3:
                    decorator = new DecoratorMargin();
                    break;
            }
            decorator.read();
            decorator.print();
        }
    }
}
