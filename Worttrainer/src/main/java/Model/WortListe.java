package Model;

public class WortListe {
    private WortEintrag[] arr=new WortEintrag[0];

    /**
     * Diese Methode fügt ein Wortenitrag zur Wortliste hinzu.
     * @param w
     */
    public void add(WortEintrag w){
        WortEintrag[] temp=new WortEintrag[arr.length+1];
        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        temp[temp.length-1]=w;
        arr=temp;
    }

    /**
     * Diese Methode holt sich den Worteintrag an der Stelle z.
     * @param z
     * @return
     */
    public WortEintrag getArr(int z) {
        if (z < 0 || z >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + z);
        }
        return arr[z];
    }


    /**
     * Diese Methode löscht den Worteintrag mit dem Wort w.
     * @param w
     * @return
     */
    public boolean delet(String w){
        boolean temp=false;
        for(int i=0;i< arr.length;i++){
            if(w.equals(arr[i].getW())){
                arr[i]=null;
                temp=true;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==null&&arr.length>1){
                arr[i]=arr[i+1];
            }
        }
        return temp;
    }

    /**
     * diese Methode gibt die Komplette Wortliste aus.
     * @return
     */
    @Override
    public String toString(){
        String temp="";

        for(int i=0;i< arr.length;i++){
            temp=temp+arr[i]+"\n";
        }

        return temp;
    }

    /**
     * Diese Methode gibt der Länge der Wortliste zurück.
     * @return
     */
    public int leange(){
        return arr.length;
    }

}

