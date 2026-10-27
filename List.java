public class List{
        //SUPPORTS:
        //  byte,short,int,long
        //  float,double
        //  char,float
        //  bool
        //  list converted right with .to2dimlist() and the nals oconverted back right with backtolist(str,sep)
        //
        //ERRORS:
        //  err1 means: not compatible type
        //  err2 means: out of bounds

        //  this contains:
        
        //  Anzeige:
        //  .show()                     for converting the list to str
        //  .join(c)                    combines elements with c into a str
        //  .showadvanced()             for converting the list to str and showing types ,sep and containment
        //  .content()                  for only showing the content same as .show()
        //  .typesaString()             shows the types as a str
        //  .seperation()               shows the sepeartion as a char
        
        //  methods and info:
        //  .lenght()                   the lenght of the list
        //  .contains(e)                return true or false if e is in the list
        //  .indexof(e)                 return the index of the first value if not err2
        //  .count(e)                   how often e occours in the list
        //  .isEmpty()                  true if empty
        //  .validindexexit(i)          if the index is outside bounds raise an err2
        //  .validindex(i)              if the index is outside bounds get false

        //  int lists only:
        //  .min()                      minimum of the list
        //  .max()                      maximum of the list
        //  .sum()                      summe of the list

        //  read:
        //  .get(i)                     get an the element i as the type back
        //  .gettype(i)                 get the type as a string from an index
        //  .getstr(i)                  get the content as a string from an index
        //  .getchar(i)                  get the content as a char from an index
        //  .getbyte(i)                  get the content as a byte from an index
        //  .getshort(i)                  get the content as a short from an index
        //  .getint(i)                  get the content as a int from an index
        //  .getlong(i)                  get the content as a long from an index
        //  .getfloat(i)                  get the content as a float from an index
        //  .getdouble(i)                  get the content as a double from an index
        //  .getbool(i)                  get the content as a boolean from an index
        //  .slice(start,end)           end is exclusive return a list :O
        //  .first()                    first element
        //  .last()                     last element

        //  appending:
        //  .append(x)                  appending a element(int,str,bool) to the list
        //  .set(i,e)                   sets an element i with e
        //  .insert(i,e)                make the element e the index i and showing everything else back

        //  Multidimlist and special:
        //  all multidim list have to have diffrent seperations
        //  .to2dimlist()               returns a list ready to be put in a list 
        //  split(list,sep)             makes str to a list with a char
        //  backtolist(list,sep)        makes a index list ausgabe to a list

        //  working with the list:
        //  .reverse()                  reverses the list
        //  .copy()                     return a copy (not linked)

        //  deleting:
        //  .pop(i)                     deletes the index i and return the element
        //  .delete(i)                  deletes the index i
        //  .remove(e)                  removes the first element
        //  .clear()                      clears the list completly

        //debug and build in:
        //toString()                    built in replaced make it so the list automaticly gets convertet to an str if printed
        //Objecttostr(x)                return the type of the object as a str zB:int,str,bool
        //Parsestrwithtype(x,type)      parses x(str) with the type(str) to a real element 

        String content;
        String type;
        char sep;
        public List(){
            this.content="[]";
            this.type="[]";
            this.sep=',';
        }
        public List(char sep){
            this.content="[]";
            this.type="[]";
            this.sep=sep;
        }
        //simple
        public String show() {
            return this.content;
        }
        public String showadvanced() {
            return "List(\ncontent: "+this.content+"\ntypes:   "+this.type+"\nsep: "+this.sep+"\n)";
        }
        public String to2dimlist() {
            String tmp="";
            for (int i=0;i<this.lenght();i++){
                if (i==0){
                    tmp+="(";
                }
                tmp+=this.getstr(i);
                if (i==this.lenght()-1){
                    tmp+=")";
                }else{
                    tmp+=this.sep;
                }
            }
            return tmp;
        }
        public String join(String c){
            String tmp="";
            for(int i=0;i<this.lenght();i++){
                if (i!=0){
                    tmp+=c;
                }
                tmp+=this.getstr(i);
            }
            return tmp;
        }
        public String content(){
            return this.content;
        }
        public String typesaString(){
            return this.type;
        }
        public char seperation(){
            return this.sep;
        }
        public boolean validindex(int index){
            if (index<0 || index>=this.lenght()){
                return false;
            }
            return true;
        }
        public void validindexexit(int index){
            if (index<0 || index>=this.lenght()){
                System.exit(2);//out of bounds
            }
        }
        //advanced
        public int lenght(){
            if (this.content.equals("[]")){
                return 0;
            }
            int i=1;
            int i2=0;
            while (true){
                if (this.content.charAt(i2)==this.sep){
                    i+=1;
                }else if (this.content.charAt(i2)==']'){
                    return i;
                }
                i2++;
            }
        }
        public void append(Object x) {
            String tmp1=this.Objecttostr(x);
            if (this.type.length()>2){
                this.type=this.type.substring(0, this.type.length()-1)+this.sep+tmp1+"]";
                this.content=this.content.substring(0, this.content.length()-1)+this.sep+x+"]";
            }else{
                this.type="["+tmp1+"]";
                this.content="["+x+"]";
            }
        }
        public String gettype(int index){
            validindexexit(index);
            int i=0;
            int i2=1;
            String tmp="";
            while (i<=index){
                if (this.type.charAt(i2)==this.sep || this.type.charAt(i2)==']'){
                    if (i==index){
                        return tmp;
                    }
                    tmp="";
                    i+=1;
                }else{
                    tmp+=this.type.charAt(i2);
                }
                i2++;
            }
            return null;
        }
        public String getstr(int index){
            validindexexit(index);
            int i=0;
            int i2=1;
            String tmp="";
            while (i<=index){
                if (this.content.charAt(i2)==this.sep || this.content.charAt(i2)==']'){
                    if (i==index){
                        return tmp;
                    }
                    tmp="";
                    i+=1;
                }else{
                    tmp+=this.content.charAt(i2);
                }
                i2++;
            }
            return null;
        }
        public char getchar(int index){
            String a=getstr(index);
            return a.charAt(0);
        }
        public byte getbyte(int index){
            String a=getstr(index);
            return Byte.parseByte(a);
        }
        public Short getshort(int index){
            String a=getstr(index);
            return Short.parseShort(a);
        }
        public int getint(int index){
            String a=getstr(index);
            return Integer.parseInt(a);
        }
        public Long getlong(int index){
            String a=getstr(index);
            return Long.parseLong(a);
        }
        public Float getfloat(int index){
            String a=getstr(index);
            return Float.parseFloat(a);
        }
        public Double getdouble(int index){
            String a=getstr(index);
            return Double.parseDouble(a);
        }
        public Boolean getbool(int index){
            String a=getstr(index);
            return Boolean.parseBoolean(a);
        }
        public List getlist(int index,char sep){
            String a=getstr(index);
            return backtolist(a,sep);
        }
        public Object get(int index){
            String type=this.gettype(index);
            String x=getstr(index);
            return this.Parsestrwithtype(x, type);
        }
        public Object first(){
            return get(0);
        }
        public Object last(){
            return get(this.lenght()-1);
        }
        public List slice(int start,int end){
            List lst=new List(this.sep);
            for (int i=start;i<end;i++){
                lst.append(this.get(i));
            }
            return lst;
        }
        public void set(int index,Object content){
            validindexexit(index);
            int l=this.lenght();
            String c="[";
            String t="[";
            for (int i=0;i<l;i++){
                if (i>0){
                    c+=this.sep;
                    t+=this.sep;
                }
                if (i!=index){
                    c+=this.getstr(i);
                    t+=this.gettype(i);
                }else{
                    c+=content;
                    t+=this.Objecttostr(content);
                }
            }
            this.content=c+"]";
            this.type=t+"]";
        }
        public void reverse(){
            String c="[";
            String t="[";
            for (int i=this.lenght()-1;i>=0;i-=1){
                if (i!=this.lenght()-1){
                    c+=this.sep;
                    t+=this.sep;
                }
                c+=this.getstr(i);
                t+=this.gettype(i);
            }
            this.content=c+"]";
            this.type=t+"]";
        }
        public List copy(){
            List lst=new List(this.sep);
            lst.content=this.content;
            lst.type=this.type;
            return lst;
        }
        public boolean isEmpty(){
            if (this.lenght()==0){
                return true;
            }
            return false;
        }
        public boolean contains(Object check){
            for (int i=0;i<this.lenght();i++){
                if (this.Parsestrwithtype(this.getstr(i),this.gettype(i)).equals(check)){
                    return true;
                }
            }
            return false;
        }
        public int indexof(Object check){
            for (int i=0;i<this.lenght();i++){
                if (this.Parsestrwithtype(this.getstr(i),this.gettype(i)).equals(check)){
                    return i;
                }
            }
            System.exit(2);//out of bounds
            return -1;
        }
        public int count(Object check){
            int c=0;
            for (int i=0;i<this.lenght();i++){
                if (this.Parsestrwithtype(this.getstr(i),this.gettype(i)).equals(check)){
                    c+=1;
                }
            }
            return c;
        }
        //contains(value) — check if an element exists
        public void insert(int index,Object content){
            int l=this.lenght();
            if (index>=l){
                this.append(content);
                return;
            }
            String c="[";
            String t="[";
            for (int i=0;i<l;i++){
                if (i>0){
                    c+=this.sep;
                    t+=this.sep;
                }
                if (i!=index){
                    c+=this.getstr(i);
                    t+=this.gettype(i);
                }else{
                    c+=content;
                    t+=this.Objecttostr(content);
                    c+=this.sep;
                    t+=this.sep;
                    c+=this.getstr(i);
                    t+=this.gettype(i);
                }
            }
            this.content=c+"]";
            this.type=t+"]";
        }
        public Object pop(int index){
            int l=this.lenght();
            String c="[";
            String t="[";
            Object o="ERROR";
            for (int i=0;i<l;i++){
                if (i!=index){
                    if (i>0){
                    c+=this.sep;
                    t+=this.sep;
                    }
                    c+=this.getstr(i);
                    t+=this.gettype(i);
                }else{
                    o=this.Parsestrwithtype(this.getstr(i),this.gettype(i));
                }
            }
            this.content=c+"]";
            this.type=t+"]";
            return o;
        }
        public void delete(int index){
            this.pop(index);
        }
        public void remove(Object x){
            this.pop(this.indexof(x));
        }
        public void clear(){
            this.content="[]";
            this.type="[]";
        }
        //int only:
        public int min(){
            int m=this.getint(0);
            for (int i=0;i<this.lenght();i++){
                int tmp=this.getint(i);
                if (tmp<m){
                    m=tmp;
                }
            }
            return m;
        }
        public int max(){
            int m=this.getint(0);
            for (int i=0;i<this.lenght();i++){
                int tmp=this.getint(i);
                if (tmp>m){
                    m=tmp;
                }
            }
            return m;
        }
        public int sum(){
            int m=0;
            for (int i=0;i<this.lenght();i++){
                int tmp=this.getint(i);
                m+=tmp;
            }
            return m;
        }
        //CODE ONLY
        @Override
        public String toString() {
            return this.content;
        }
        public String Objecttostr(Object x){
            String tmp1="";
            if (x instanceof Byte) {
                tmp1="byte";
            }else if (x instanceof Short) {
                tmp1="short";
            }else if (x instanceof Integer) {
                tmp1="int";
            }else if (x instanceof Long) {
                tmp1="long";
            }else if (x instanceof Float) {
                tmp1="float";
            }else if (x instanceof Double) {
                tmp1="double";
            }else if (x instanceof Character) {
                tmp1="char";
            }else if (x instanceof String) {
                tmp1="str";
            }else if (x instanceof Boolean) {
                tmp1="bool";
            }else{
                System.exit(1);//not compatible type yet
            }
            return tmp1;
        }
        public Object Parsestrwithtype(String x,String type){
            if (type.equals("byte")){
                return Byte.parseByte(type);
            }else if (type.equals("short")){
                return Short.parseShort(x);
            }else if (type.equals("int")){
                return Integer.parseInt(x);
            }else if (type.equals("long")){
                return Long.parseLong(x);
            }else if (type.equals("float")){
                return Float.parseFloat(x);
            }else if (type.equals("double")){
                return Double.parseDouble(x);
            }else if (type.equals("char")){
                return x.charAt(0);
            }else if (type.equals("str")){
                return x;
            }else if (type.equals("bool")){
                return Boolean.parseBoolean(x);
            }else{
                System.exit(1);//not compatible type yet
                return null;
            }
        }
    public static List backtolist(String lst,char sep){
            List a=new List(sep);
            String tmp="";
            for (int i=1;i<lst.length();i++){
                if (i!=lst.length()-1){
                    char aaa=lst.charAt(i);
                    if (aaa==sep){
                        a.append(tmp);
                        tmp="";
                    }else{
                        tmp+=aaa;
                    }
                }
            }
            if (tmp.length()>0){
                a.append(tmp);
            }
            return a;
    }
    public static List split(String lst,char sep){
            List a=new List(sep);
            String tmp="";
            for (int i=0;i<lst.length();i++){
                char aaa=lst.charAt(i);
                if (aaa==sep){
                    a.append(tmp);
                    tmp="";
                }else{
                    tmp+=aaa;
                }
            }
            if (tmp.length()>0){
                a.append(tmp);
            }
            return a;
    }
}