# VVideoBackground
Android SurfaceView to use Video as a background

VVideoBackground provides a very simple way to add a video background that you might have seen in some of the Apps such as OnvoTV, Ragam 17 etc. VVideoBackground works as an independent android element without interfering in any other views. 

![Demo](https://github.com/vrjgamer/VVideoBackground/blob/master/demo.gif)

Getting started
======

### Prerequisities
* minimum sdk version should be API 16


###  People using gradle
* Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
      allprojects {
    		repositories {
    			...
    			maven { url "https://jitpack.io" }
    		}
    	}
```
    
* Step 2. Add the dependency
```
      dependencies {
    	        compile 'com.github.vrjgamer:VImageButtonView:1.0'
    	}
```
###  People using maven
* Step 1. Add the JitPack repository to your build file
```
      <repositories>
    		<repository>
    		    <id>jitpack.io</id>
    		    <url>https://jitpack.io</url>
    		</repository>
    	</repositories>
    
```
* Step 2. Add the dependency
```
      <dependency>
    	    <groupId>com.github.vrjgamer</groupId>
    	    <artifactId>VImageButtonView</artifactId>
    	    <version>1.0</version>
    	</dependency>
```

### How To Use: 
* Firstly, create a raw folder in your res folder and add your video file (recommended [format:mp4, resolution: 720x1280])
![Demo](https://github.com/vrjgamer/VVideoBackground/blob/master/demo.gif)
* Add VVideoBackground element to your xml layout
```
    ...
      <com.vrjco.v.vbackgroundvideoview.VVideoBackground
        android:id="@+id/videobg"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_centerInParent="true" />
    ...  
```
* Then, go to your activity of fragment and link the view from the xml layout.
```
  ...
       VVideoBackground videoBG = (VVideoBackground) findViewById(R.id.videobg);
  ...
     
```
* Finally, attach the video from your raw folder to your VVideoBackground View, using setBackgroundVideo(R.raw....);
```
  ...
       VVideoBackground videoBG = (VVideoBackground) findViewById(R.id.videobg);
       videoBG.setBackgroundVideo(R.raw.video);
  ...
     
```

======
For any other query you can email {vrjgamer@gmail.com} or raise an issue.
