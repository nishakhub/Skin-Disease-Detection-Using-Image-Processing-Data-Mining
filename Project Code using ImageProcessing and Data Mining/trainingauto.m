FileData = load('db.mat'); 
csvwrite('db.csv', FileData.db);
dbtable = readtable('db.csv');
dbtable.Properties.VariableNames{1} = 'en1';
dbtable.Properties.VariableNames{2} = 'meanval';
dbtable.Properties.VariableNames{3} = 'meabs';
dbtable.Properties.VariableNames{4} = 'medabd';
dbtable.Properties.VariableNames{5} = 'ener1';
dbtable.Properties.VariableNames{6} = 'stdA';
dbtable.Properties.VariableNames{7} = 'L1norm';
dbtable.Properties.VariableNames{8} = 'L2norm';
dbtable.Properties.VariableNames{9} = 'k';
dbtable.Properties.VariableNames{10} = 's';
dbtable.Properties.VariableNames{11} = 'cor1';
dbtable.Properties.VariableNames{12} = 'm';
dbtable.Properties.VariableNames{13} = 'en12';
dbtable.Properties.VariableNames{14} = 'ener12';
dbtable.Properties.VariableNames{15} = 'cor12';
dbtable.Properties.VariableNames{16} = 'conts';
dbtable.Properties.VariableNames{17} = 'ener';
dbtable.Properties.VariableNames{18} = 'homo';
dbtable.Properties.VariableNames{19} = 'corre';
dbtable.Var20{1,1} = 'melanoma';

for i=1:154 ; dbtable.Var20{i,1} = 'melanoma'; end
for i=155:250 ; dbtable.Var20{i,1} = 'eczema'; end
for i=251:346 ; dbtable.Var20{i,1} = 'impetigo'; end
for i=347:408 ; dbtable.Var20{i,1} = 'nodisease'; end


