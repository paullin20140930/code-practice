 public static boolean isSum( int x, int y,int dx, int dy){
		if(x == dx && y == dy)
			return true;
		if( x >dx || y > dy)
			return false;
		
	   boolean l = isSum(x,y+x,dx,dy);
	   boolean r = isSum(x+y, y, dx ,dy);
		
	   return l||r ;
		
		
 }