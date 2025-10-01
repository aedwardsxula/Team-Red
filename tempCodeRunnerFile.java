//Round the value down to the nearest integer
            int intVal = (int) Math.floor(val);

            if(Tmap.containsKey(intVal)){
                Tmap.put(intVal, Tmap.get(intVal) + 1);
            } else {
                Tmap.put(intVal, 1);
            }
        }
        //Get the max value in the TreeMap
        int max = Collections.max(Tmap.values());

        //Print the histogram
        for(int i = max; i > 0; i--){
            for(int key : Tmap.keySet()){
                if(Tmap.get(key) >= i){
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

        for(int key : Tmap.keySet()){
            System.out.print(String.format("%2d ", key));
        }
        System.out.println();