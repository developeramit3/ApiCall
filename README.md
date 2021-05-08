# Add it in your root build.gradle at the end of repositories:
# ApiCall


     allprojects {

		repositories {
		
			maven { 
			url 'https://jitpack.io' 
			}
		}
	}
		
	Step 2. Add the dependency
	
	dependencies {
	       implementation 'com.github.developeramit3:ApiCall:1c3c891913'
	}
	
 "# ApiCall"       
				
# Step 3. How use
"# ApiCall"				
				
    ApiCallBuilder.build(this)
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
   [![](https://jitpack.io/v/developeramit3/ApiCall.svg)](https://jitpack.io/#developeramit3/ApiCall)
   
 
   
   [![](https://jitpack.io/v/developeramit3/ApiCall.svg)](https://jitpack.io/#developeramit3/ApiCall)
    
    
   "# ApiCall"
