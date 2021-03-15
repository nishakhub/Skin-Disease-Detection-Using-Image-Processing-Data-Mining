for i=69:82
cd Dataset\nodisease
st=int2str(i)
str=strcat(st,'.jpg');
im=imread(str);
cd D:\cnn
y = imresize(im,[221 293]);
newfilename=strcat('D:\cnn\Dataset\nodisease1\',str);
imwrite(y,newfilename,'jpg');
end