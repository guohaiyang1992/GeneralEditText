## **GeneralEditText**
---
###**特点：** 

 - 解决`edittext`光标在某些`rom`下无法修改的问题

###**使用步骤：** 
  

 - 导入该库


Step 1. Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency

	

```
dependencies {
	        compile 'com.github.guohaiyang1992:GeneralEditText:0.1'
	}
```


 

 - 使用`app:textCursorDrawable="@drawable/xx"`
