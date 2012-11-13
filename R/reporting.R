social <- read.csv('C:\\Users\\wes\\workspace\\socialData\\flatten\\all.txt',head=T,row.names=1)

library(graphics)
pie(colSums(social))
barplot(as.matrix(subset(social[rownames(social) > '20110701',],twitter > 0)))

library(lattice)
barchart(as.matrix(social), horizontal=FALSE, groups=names(social))


