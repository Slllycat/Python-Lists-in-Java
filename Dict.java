public class Dict {
        //  this contains:
        
        //  Anzeige:
        //  .show()                     for converting the list to str
        //
        //  tests:
        //  .contains(e)                if dict contains an element
        //  .lenght()                   lenght of how many keyvalue pairs
        //
        //  getting:
        //  .get(key)                   for getting the value to a key;
        //  .values()                   getting a list of values;
        //  .keys()                   getting a list of values;
        //
        //
        //  Appending:
        //  add(key,value)              for adding a key and value
        //  .setdefault(e,e2)           if it doesnt exist yet 
        //
        //  deleting:
        //  .pop(key)                   deletes a key and return it
        //  .pop(key,default)           deletes a key and return it and if it doesnt exist it returns default
        //  .poplast()                  deletes the last key value paar and return it
        //  .delete(key)                deletes a key

        List values;
        List keys;
        public Dict(){
            this.values= new List();
            this.keys=new List();
        }
        public void add(Object key,Object value){
            if (this.contains(key)){
                int a=this.keys.indexof(key);
                this.keys.set(a,key);
                this.values.set(a,value);
            }else{
            this.keys.append(key);
            this.values.append(value);
            }
        }
        public void setdefault(Object key,Object value){
            if (!this.contains(key)){
                this.keys.append(key);
                this.values.append(value);
            }
        }
        public Object get(Object key){
            for (int i=0;i<this.keys.lenght();i++){
                if (this.keys.get(i).equals(key)){
                    return this.values.get(i);
                }
            }
            return null;
        }
        public int lenght(){
            return this.keys.lenght();
        }
        public boolean contains(Object key){
            if (this.keys.contains(key)){
                return true;
            }else{
            return false;
            }
        }
        public String show(){
            String a="{";
            for (int i=0;i<this.values.lenght();i++){
                if (i!=0){a+=",";}
                a+=this.keys.get(i);
                a+=":";
                a+=this.values.get(i);
            }
            return a+"}";
        }
        public Object pop(Object key){
            int a=this.keys.indexof(key);
            Object tmp=this.values.get(a);
            this.keys.delete(a);
            this.values.delete(a);
            return tmp;
        }
        public void delete(Object key){
            int a=this.keys.indexof(key);
            this.keys.delete(a);
            this.values.delete(a);
        }
        public Object pop(Object key,Object defaults){
            if (this.keys.contains(key)){
                int a=this.keys.indexof(key);
                Object tmp=this.values.get(a);
                this.keys.delete(a);
                this.values.delete(a);
                return tmp;
            }else{
                return defaults;
            }
        }
        public Object poplast(){
            int a=-1;
            Object tmp=this.values.get(a);
            this.keys.delete(a);
            this.values.delete(a);
            return tmp;
        }

        @Override
        public String toString() {
            String a="{";
            for (int i=0;i<this.values.lenght();i++){
                if (i!=0){a+=",";}
                a+=this.keys.get(i);
                a+=":";
                a+=this.values.get(i);
            }
            return a+"}";
        }
    }