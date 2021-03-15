function [F]=FeatureStatistical(K);
wname = 'sym4';
[CA,CH,CV,CD] = dwt2(K,wname,'mode','per');

en1=entropy(CA);

meanval=mean2(CA);

meabs=mad(CA(:),0);

medabd=mad(CA(:),1);

ener1=sum(sum(CA.^2));

stdA=std2(CA);

L1norm=norm(CA,1);

L2norm=norm(CA,2);

k=kurtosis(CA(:));

s=skewness(CA(:));

cor1=corr(CA(:));

m=median(CA(:));

[CA1,CH2,CV3,CD4] = dwt2(CA,wname,'mode','per');

en12=entropy(CA1);

ener12=sum(sum(CA1.^2));

cor12=corr(CA1(:));

% % texture 

glcms = graycomatrix(K);

stats = graycoprops(glcms,'Contrast Correlation');

stats1 = graycoprops(glcms,{'energy','homogeneity'})

conts=stats.Contrast;

ener=stats1.Energy;

homo=stats1.Homogeneity;

corre=stats.Correlation;

F=[en1 meanval meabs medabd ener1 stdA L1norm L2norm k s cor1 m en12 ener12 cor12 conts ener homo corre];

