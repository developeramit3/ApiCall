allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  dependencies {
	        implementation 'com.github.developeramit3:ApiCall:Tag'
	}
  
  
<===========================  How To use=========================>
 private HashMap<String, String> getParam() {
        HashMap<String,String>param=new HashMap<>();
        return param;
    }
    
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
