*****how to run project with deep learning CNN Classifier*****

go to matlab software
copy paste the directory path of "project code with cnn classifier" in matlab directory path
now all the files are loaded into left side of matlab and workspace resides on right side of matlab
load all your files from folder into workspace by double clicking on files which are on left side

load all the files of "cnn classifier" into the workspace. This is the original model of cnn which made after training process

open the cnn_test file from left side and change the image number in imread() which you want to change in the code

click on run
result will be shown in command window


*****how to run project with Image processing*****

To run this project your server (Matlab) and Android app(client) should be in same network

1) Install the app in your mobile
   go to android software
   open directory called "Android/skinclinic" which is available in CD
   all android codes will get opened in android studio
   click on build
   after building the project, install this app in your mobile "install in mobile functionality is available in android studio"
   after installing your app is ready
   
2) Make Server
   go to matlab software
   copy paste the directory of "Project code using image processing in matlab"
   load all the files into the workspace
   load the svm model called "svm.m"
   open model_test code in matlab
   run model_test
   
   this is finally setup your server
   
3) Upload Image from android app and it will be communicated with Backend Server where matlab software resides, result 
will be shown in android app by clicking on result button.
   