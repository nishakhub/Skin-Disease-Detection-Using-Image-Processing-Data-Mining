%%Taking an Image
%clc
%%clear all
%close all
%[fname path]=uigetfile('Open a face as input for training','.jpg');
%fname=strcat(path,fname);
%im=imread(fname);
%imshow(im);
%# JDBC connector path
 javaaddpath('C:\Users\admin\Downloads\jdbc\mysql-connector-java-5.1.6-bin.jar')
   
   
 %# JDBC parameters
 conn=database('skinclinic', 'root', '', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost/');
   
myFolder = 'C:\xampp\htdocs\upload\assets';
olddir   = dir(myFolder);
while true
  pause(5)
  newdir = dir(myFolder);
  if ~isequal(newdir, olddir)
    fprintf('new files found\n');
    olddir = newdir;
   % jpgfiles = dir(fullfile(myFolder,'\*.jpg*'))
    filePattern = fullfile(myFolder, '*.jpg');
    jpegFiles = dir(filePattern);
    n=length(jpegFiles);
    disp(n)

    st=int2str(n)
    str=strcat(st,'.jpg');
    im= imread(fullfile(myFolder,str), 'jpg'); 
    imshow(im);
    title('Input face');    
    %c=input('Enter the class');
    im=rgb2gray(im);
    %%apply median Filter
    K=MedianFilter(im);
    imshow(K);

    thresh = multithresh(K,2);
    seg_I = imquantize(K,thresh);
    RGB = label2rgb(seg_I); 	 
    L=RGB;
    K=rgb2gray(L);
    imshow(K);

    F=FeatureStatistical(K);
    try
        load db1;
        F=[F];
        db1=[db1;F];
        save db1.mat db1
        FileData1 = load('db1.mat');
        csvwrite('db1.csv', FileData1.db1);
        dbtable1 = readtable('db1.csv');
        dbtable1.Properties.VariableNames{1} = 'en1';
        dbtable1.Properties.VariableNames{2} = 'meanval';
        dbtable1.Properties.VariableNames{3} = 'meabs';
        dbtable1.Properties.VariableNames{4} = 'medabd';
        dbtable1.Properties.VariableNames{5} = 'ener1';
        dbtable1.Properties.VariableNames{6} = 'stdA';
        dbtable1.Properties.VariableNames{7} = 'L1norm';
        dbtable1.Properties.VariableNames{8} = 'L2norm';
        dbtable1.Properties.VariableNames{9} = 'k';
        dbtable1.Properties.VariableNames{10} = 's';
        dbtable1.Properties.VariableNames{11} = 'cor1';
        dbtable1.Properties.VariableNames{12} = 'm';
        dbtable1.Properties.VariableNames{13} = 'en12';
        dbtable1.Properties.VariableNames{14} = 'ener12';
        dbtable1.Properties.VariableNames{15} = 'cor12';
        dbtable1.Properties.VariableNames{16} = 'conts';
        dbtable1.Properties.VariableNames{17} = 'ener';
        dbtable1.Properties.VariableNames{18} = 'homo';
        dbtable1.Properties.VariableNames{19} = 'corre';
        yfit = trainedModel.predictFcn(dbtable1);
        row1 = yfit([end]);
        disp(row1);
          b=string(row1);
        sqlCommand =  sprintf('insert into result (output) values (''%s'')',b);  
  
    
 
        r=exec(conn, sqlCommand); 
        
        

    catch
        db1=[F];
        save db1.mat db1
        FileData1 = load('db1.mat'); 
        csvwrite('db1.csv', FileData1.db1);
        dbtable1 = readtable('db1.csv');
        dbtable1.Properties.VariableNames{1} = 'en1';
        dbtable1.Properties.VariableNames{2} = 'meanval';
        dbtable1.Properties.VariableNames{3} = 'meabs';
        dbtable1.Properties.VariableNames{4} = 'medabd';
        dbtable1.Properties.VariableNames{5} = 'ener1';
        dbtable1.Properties.VariableNames{6} = 'stdA';
        dbtable1.Properties.VariableNames{7} = 'L1norm';
        dbtable1.Properties.VariableNames{8} = 'L2norm';
        dbtable1.Properties.VariableNames{9} = 'k';
        dbtable1.Properties.VariableNames{10} = 's';
        dbtable1.Properties.VariableNames{11} = 'cor1';
        dbtable1.Properties.VariableNames{12} = 'm';
        dbtable1.Properties.VariableNames{13} = 'en12';
        dbtable1.Properties.VariableNames{14} = 'ener12';
        dbtable1.Properties.VariableNames{15} = 'cor12';
        dbtable1.Properties.VariableNames{16} = 'conts';
        dbtable1.Properties.VariableNames{17} = 'ener';
        dbtable1.Properties.VariableNames{18} = 'homo';
        dbtable1.Properties.VariableNames{19} = 'corre';
        yfit = trainedModel.predictFcn(dbtable1);
        row1 = yfit([end]);
        disp(row1);
        b=string(row1);
        sqlCommand =  sprintf('insert into result (output) values (''%s'')',b);  
    
 
        r=exec(conn, sqlCommand); 
        
end
 else
    fprintf('no new files\n')
  end
end
