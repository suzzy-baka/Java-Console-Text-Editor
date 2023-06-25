import java.util.Scanner;  // To import Scanner class from util package

public class Main

{  // Start of class

  public static void main(String[] args)

  {  //Start of main() method

    Scanner sc = new Scanner(System.in);

    // Variables Used

    String str = "", clip = "";
    int index_1 = 0, index_2 = 0, del_1, del_2, paste = 0;
    char i;

    while (true)

    {  // Start of while loop

      // Operation Prompt

      System.out.println("\nThe letter for the operation:\n");

      System.out.println("(a) Text Typing");
      System.out.println("(b) Copy Text");
      System.out.println("(c) Cut Text");
      System.out.println("(d) Paste Text");
      System.out.println("(e) Delete Text");
      System.out.println("(x) Exit");

      System.out.print("\nEnter the operation letter: ");

      // Take The Operation Number

      i = sc.next().charAt(0);
      System.out.println();

      // Check What Operation The User Wants

      switch (i)

      {  // Start of switch statement

        // For Text Typing

        case 'a':
          System.out.println("Enter the text below:\n");
          System.out.print(str);
          sc.nextLine();
          str += sc.nextLine();
          break;

        // For Copying Text

        case 'b':
          if(str.length() == 0)
              System.out.println("No Text is present\n");

          else

          {  // Start of else statement

            System.out.println(str + "\n");
            System.out.println("Enter the first and last index of the portion you want to copy:\n");
            sc.nextLine();
            index_1 = sc.nextInt();
            index_2 = sc.nextInt();
            
            while(index_1 >= str.length() || index_2 >= str.length() || index_1 < 0 || index_2 < 0)

            {  // Start of while loop
              
                System.out.println("INVALID Index! Retry!\n");
                index_1 = sc.nextInt();
                index_2 = sc.nextInt();
              
            }  // End of while loop

            clip = str.substring(Math.min(index_1, index_2), Math.max(index_1, index_2));
              
          }  // End of else statement

          break;

        // To Cut Text

        case 'c':
          if(str.length() == 0)
              System.out.println("No Text is present\n");

          else

          {  // Start of else statement

            System.out.println(str + "\n");
            System.out.print("Enter the first index of the portion u want to cut: ");
            index_1 = sc.nextInt();
            System.out.print("Enter the last index of the portion u want to cut: ");
            index_2 = sc.nextInt();

            while(index_1 >= str.length() || index_2 >= str.length() || index_1 < 0 || index_2 < 0)

            {  // Start of while loop

              System.out.println("INVALID Index! Retry!\n");
              index_1 = sc.nextInt();
              index_2 = sc.nextInt();

            }  // End of while loop

            clip = str.substring(Math.min(index_1, index_2), Math.max(index_1, index_2));
            str = str.substring(0, Math.min(index_1, index_2)) + str.substring(Math.max(index_1, index_2), str.length());
            System.out.println("\nUpdated Text:\n" + str);

          }  // End of else statement

          break;

        // To Paste Text

        case 'd':
          if(str.length() == 0)
              System.out.println("No Text is present\n");
          else

          {  // Start of else statement

            if(clip == "")

            {  // Start of if statement

              System.out.println("Clipboard is empty!");

            }  // End of if statement

            else

            {  // Start of else statement

              System.out.print("Enter the index of the character, before which you want to paste: ");
              paste = sc.nextInt();
              while(paste >= str.length() || paste < 0)

              {  // Start of while loop

                System.out.println("INVALID Index! Retry!\n");
                paste = sc.nextInt();

              }  //End of while loop

              str = str.substring(0, paste) + clip + str.substring(paste, str.length());
              System.out.println("\nUpdated Text\n" + str);

            }  // End of else statement

          }  // End of else statement

          break;

        // To Delete Text

        case 'e':
          if(str.length() == 0)
              System.out.println("No Text is present\n");

          else

          {  // Start of else statement

            System.out.println(str + "\n");
            System.out.println("Enter the first and last index of the portion, to be deleted:\n");
            sc.nextLine();
            del_1 = sc.nextInt();
            del_2 = sc.nextInt();
            while(del_1 >= str.length() || del_2 >= str.length() || del_1 < 0 || del_2 < 0)

            {  // Start of while loop

                System.out.println("INVALID Index! Retry!\n");
                del_1 = sc.nextInt();
                del_2 = sc.nextInt();

            }  // End of while loop

            str = str.substring(0, Math.min(del_1, del_2)) + str.substring(Math.max(del_1, del_2), str.length());
            System.out.println("\nUpdated Text:\n" + str);

          }  // End of else statement

          break;

        // To exit the program

        case 'x':
          System.exit(0);

        // For Invalid Input

        default:
          System.out.println("Invalid Input. Retry\n");

      }  // End of switch statement

    }  // End of while loop

  }  // End of main() method

}  // End of class
