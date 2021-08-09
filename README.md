# Mortgage-Calculator

This is an app that would calculate the monthly mortgage payment based on the 
duration and the interest rate of the loan. 
This application was coded Android Studio Platform. 

All XML codes were written in activity_main.xml source code.
This source code contains the codes that were used to make the structure of the application. 

The widgets used in the app were placed in a linear layout. 
This layout was a suitable option for the organization and aesthetic appearance of the app. 

Next, EditText widgets were used to display the monthly payment and for the user 
to input the numbers such as purchase price, down payment, and interest rate. 

After that, a SeekBar widget was added to allow the user to determine the loan length. 
They can use their thumb to drag on the bar to adjust the loan length in years. 

Lastly, two buttons were created where one button calculates the monthly payment and the other reset it back to its original form. 

The functionality of the app was coded with Java in the MainActivity source code. 
Here the Buttons, EditText, and Seekbar created by XML codes were made functional with action listener code. 

The maximum value of the seekbar was set to 3, and the incremental value was set to 10. 
To accomplish this task or set the current progress of the seek bar, 
the progress of the seek bar was multiplied by 10. 
This calculation set the max value of the seekbar to 30 while the incremental value to 10. 

The most important part of this app development was the actual calculation. 
The formula for calculating monthly mortgage payment is 

M = P*((r*((1+r)^n))/(((1+r)^n)-1)), where:

- M represents the total monthly mortgage payment 
- P is the principal loan amount 
- r is the monthly interest rate
- n is the number of payments over the loan's lifetime

The principal or P-value for the equation can be found by subtracting the down payment from the purchase price. 
Since these values might have decimal points, float identification was used for the variable. 

So in Java, this equation was written as
float principal = purchaseAmount – downPayment; 

Next, to find the monthly interest rate r, it was necessary to convert the interest rate 
in percentage entered by the user to a decimal point. 

It is also important to realize that the user will enter the annual interest rate. 
Therefore, to convert the entered annual interest rate into monthly interest, 
the entered interest rate will be divided by 100 to convert it to decimal and then 
divided by 12 to convert it from annual to the monthly rate. 

So in Java, this calculation was represented by the code
float monthly_interest_rate = ((interest_rate/100)/12);

Lastly, the number of payments over the loan's lifetime or n value is calculated by 
multiplying the currentProgress of the seekbar with 12. 

After that, these values were plugged into the formula mentioned above to find the monthly mortgage payment. 
