//package com.tlc.crm.start;
//
//import com.tlc.crm.crud.api.CrudManager;
//import com.tlc.crm.crud.model.Student;
//
//import java.util.Scanner;
//
//public class Main {
//
//    private static final Scanner SCANNER = new Scanner(System.in);
//    private static final CrudManager CRUD_MANAGER = CrudManager.getInstance();
//    private static final Student studentModel = new Student();
//
//    public static void start() {
////        System.out.println("Student:" + Table.get("Student"));
//        int choice = 0;
//        do {
//            System.out.println("1.Insert \n 2.Select \n 3.Update \n 4.Delete \n 5.Exit \n Enter Your Choice:");
//            choice = SCANNER.nextInt();
//
//            switch (choice) {
//                case 1:
//                    CrudManager.getInstance().create(new Student());
//                    break;
//                case 2:
//                    System.out.println("Enter Id to Search:");
//                    CrudManager.getInstance().get(SCANNER.nextLong());
//                    break;
//                case 3:
//                    CrudManager.getInstance().update(new Student());
//                    break;
//                case 4:
//                    System.out.println("Enter id to delete:");
//                    studentModel.setId(SCANNER.nextLong());
//
//                    CrudManager.getInstance().delete(studentModel);
//                    break;
//                case 5:
//                    SCANNER.close();
//                    System.exit(0);
//            }
//        } while (choice < 5);
//
//
//    }
//
////    public static void add(){
////
//////        System.out.println("Enter Id:");
//////        studentModel.setID(SCANNER.next());
////        System.out.println("Enter Name:");
////        String Name = studentModel.setName(SCANNER.next());
////        System.out.println("Enter Age");
////        String Age = studentModel.setAge(SCANNER.next());
////        final StudentModel student = new StudentModel(Name, Age);
////        CRUD_MANAGER.create(student);
////        System.out.println(student);
////
////    }
//    public static void delete(){
//
//
//    }
//
//
//}
