%%Taking an Image
clc
clear all
close all
for i=1:62
cd Database\nodisease
st=int2str(i)
str=strcat(st,'.jpg');
im=imread(str);
cd D:\programs
%imshow(im);

%title('Input face');    
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
    load db;
    F=[F];
    db=[db;F];
    save db.mat db
catch
    db=[F];
    save db.mat db
end


end