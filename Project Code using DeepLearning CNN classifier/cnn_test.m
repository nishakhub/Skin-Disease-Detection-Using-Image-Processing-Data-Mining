%j=357
for i=1:82
cd Dataset\nodisease
st=int2str(i)
str=strcat(st,'.jpg');
m=imread(str);


cd D:\cnn
y = imresize(m,[221 293]);
output=classify(convnet,y);
output

%C = cellstr(output)
%b.Var1(j)= C
%j=j+1

%plotconfusion(targets,result);
end

