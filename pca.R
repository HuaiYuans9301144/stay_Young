setwd('C:\\Users\\USER\\Desktop')
dat<- read.csv('air_v.csv', header=T) 
#original data 分別代入air_v|factory_v|health_v/|traffic_v|計算pca計分
dat #print data
#dat$v5<- as.numeric(dat$v5)
dat<- scale(dat) #standardized data
pca<- princomp(dat, cor=F)
pca #eigenvalue
summary(pca) #summary eigenvalue
pca$loadings #eigenvector
plot(pca)
print(-1*pca$loadings, digits=8, cutoff=0)
-1*pca$scores #principal components scores
options(max.print = 9999)
cor(cbind(-1*pca$scores,dat), method='pearson') #loading
biplot(pca)

