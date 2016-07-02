# TestMeasureView
three meathod to measuer the view width and height


the situation one:

    use the view.post() to measure the height and width
    
        imageView.post(new Runnable() {
            @Override
            public void run() {
                if (imageView.getWidth()>imageView.getHeight()){
                    Log.e("TAG", "width:" + imageView.getWidth());
                    Log.e("TAG","height:"+imageView.getHeight());
                }else{
                    Log.e("TAG","width:"+imageView.getWidth());
                    Log.e("TAG","height:"+imageView.getHeight());
                }
            }
        });
        
the situation two:
 
    use the ViewTreeObserver.onGlobalLayoutListener to measure the height and width
    
        mTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        
            @Override
            public void onGlobalLayout() {
                int a = mTextView.getWidth();
                Log.e("TAG","GlobalLayoutListener Width:"+a);
                mTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            
        });
    in this meathod :mTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this); must to be added
    
the situation three:

    to override the onLayout meathod to get the view width and height
    
        @Override
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
          super.onLayout(changed, l, t, r, b);
          int a = imageView.getWidth();
          Log.e("TAG","Layout view width:"+a);
        }
        
but ,all the method is to get the width and height after onResume 
