Add it in your root build.gradle at the end of repositories:
"# ApiCall"


     allprojects {

		repositories {
		
			maven { 
			url 'https://jitpack.io' 
			}
		}
	}
		
	Step 2. Add the dependency
	
	dependencies {
	        implementation 'com.github.developeramit3:ApiCall:3f69458b5d'
	}
	
 "# ApiCall"       
				
Step 3. How use
"# ApiCall"				
				
    new ApiCallBuilder().build(this)
                .isShowProgressBar(true)
                .setParam(getParam())
                .setUrl("url")
                .setFile("image","file_path")
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {

                    }

                    @Override
                    public void Failed(String error) {

                    }
                });
								
								
	private HashMap<String, String> getParam() {
        HashMap<String,String>param=new HashMap<>();
        return param;
    }
    
    
    
   "# ApiCall"