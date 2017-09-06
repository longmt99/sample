- This is one part source code of project school management
- Template using 
   Spring Boot, SaaS, MVP, 
   AWS, Docker, Lambda, 
   SpringMyBatis, Hibernate, 
   Multi Tenanant, Coginito
- Refer URL demonstrate backend service at:
- http://dev.api-gateway.s3-website-us-east-1.amazonaws.com/
- Project include modules as: school-api. user-api, tenant-api, student-api(sample here)...
- This is model micro service, multi tenant model, 


### Steps to run code locally -
	+ Install Eclipse
	+ Import the project as Existing Maven Project: Project required:
		+ common-lib 
		+ api-gateway
		Some define:
			+ Profiles: local, lambda, docker
			+ Environements: local, dev, sandbox prod  
	+ Add Environment variable in Run configuration sping.profile.active=dev
	+ Eclipse: Run Application.java
 
### Steps to deploy lambda
	+ Eclipse: Build zip by run "maven clean assembly:single -f pomzip.xml" profile: lambda
	+ Eclipse: Commit zip file, zip push from bitbucker to S3
	+ Waiting S3 done
	+ AWS: Run build jar, artifact jar out will storage at folder aritifact (S3) 
	       (This step can auto by pipelile Aws but charge a litle fee after 1 month)
	+ AWS: The artifact use to deployment package of your Lambda function.
	+ AWS: Make test lambda function at folder source code eclipse "lambda"
	+ AWS: Deploy api-gateway project 

### Steps to deploy docker
	+ Terminal need install aws client
	$ docker --version
	$ aws --version
	$ aws config
	$ (aws ecr get-login --region us-east-1)
	$ cd school-api    
    $ docker build -t school_api --build-arg env_name=dev -f docker/Dockerfile .
    $ docker run --name school_api -d -e spring.profiles.active="dev" school_api
  	$ docker logs -f school_api
    $ docker commit school_api ${awsAccountId}.dkr.ecr.us-east-1.amazonaws.com/dev:school_api
    $ docker push ${awsAccountId}.dkr.ecr.us-east-1.amazonaws.com/dev:school_api