package src.src.algoexpert.veryHard;

import java.util.*;

public class ApartmentHunting {

    public static int apartmentHunting(
            List<Map<String, Boolean>> blocks, String[] reqs
    ) {
        // Write your code here.
        int [] maxDistLeft = new int[blocks.size()];
        int [] maxDistRight = new int[blocks.size()];

        Map<String, Integer> reqDist = new HashMap<>();

        for(int i = 0; i<blocks.size(); i++) {
            Map<String, Boolean> apartment = blocks.get(i);
            for(String req: reqs) {
                if (apartment.get(req)) {
                    reqDist.put(req, 0);
                }else {
                    if (reqDist.containsKey(req)) {
                        reqDist.put(req, reqDist.get(req)+1);
                    }

                }
            }

            maxDistLeft[i] = getMaxDistance(reqDist, reqs);
        }
        reqDist.clear();

        for(int i = blocks.size()-1; i>=0; i--) {
            Map<String, Boolean> apartment = blocks.get(i);
            for(String req: reqs) {
                if (apartment.get(req)) {
                    reqDist.put(req, 0);
                }else {
                    if (reqDist.containsKey(req)) {
                        reqDist.put(req, reqDist.get(req)+1);
                    }

                }
            }

            maxDistRight[i] = getMaxDistance(reqDist, reqs);
        }
        int minDistances = Integer.MAX_VALUE;
        int optimalIdx = -1;
        for(int i = 0; i < maxDistRight.length; i++) {
            int maxDistToReqs = Math.min(maxDistLeft[i], maxDistRight[i]);
            if (maxDistToReqs <= minDistances){
                minDistances = maxDistToReqs;
                optimalIdx = i;
            }
        }

        return optimalIdx;
    }

    public static int getMaxDistance (Map<String, Integer> map, String[] reqs) {
        int res = 0;
        for (String req: reqs) {
            if (!map.containsKey(req)) {
                return Integer.MAX_VALUE;
            }
            int distance = map.get(req);
            res = Math.max(res, distance);
        }
        return res;
    }

    public static void main(String [] args) {
        List<Map<String, Boolean>> blocks = new ArrayList<>();

//        for(int i = 0; i < 7; i++) {
//            Map<String, Boolean> apartment = new HashMap<>();
//            apartment.put("gym", Math.random() < 0.5);
//            apartment.put("school", Math.random() < 0.5);
//            apartment.put("park", Math.random() < 0.5);
//            blocks.add(apartment);
//        }
        // Add first block
        Map<String, Boolean> block1 = new HashMap<>();
        block1.put("gym", false);
        block1.put("school", true);
        block1.put("store", false);
        blocks.add(block1);

        // Add second block
        Map<String, Boolean> block2 = new HashMap<>();
        block2.put("gym", true);
        block2.put("school", false);
        block2.put("store", false);
        blocks.add(block2);

        // Add third block
        Map<String, Boolean> block3 = new HashMap<>();
        block3.put("gym", true);
        block3.put("school", true);
        block3.put("store", false);
        blocks.add(block3);

        // Add fourth block
        Map<String, Boolean> block4 = new HashMap<>();
        block4.put("gym", false);
        block4.put("school", true);
        block4.put("store", false);
        blocks.add(block4);

        // Add fifth block
        Map<String, Boolean> block5 = new HashMap<>();
        block5.put("gym", false);
        block5.put("school", true);
        block5.put("store", true);
        blocks.add(block5);
        String[] reqs = new String[]{"gym", "school", "store"};
        int res = apartmentHunting(blocks, reqs);
    }

    /*
    * {
  "blocks": [
    {
      "gym": false,
      "school": true,
      "store": false
    },
    {
      "gym": true,
      "school": false,
      "store": false
    },
    {
      "gym": true,
      "school": true,
      "store": false
    },
    {
      "gym": false,
      "school": true,
      "store": false
    },
    {
      "gym": false,
      "school": true,
      "store": true
    }
  ],
  "reqs": ["gym", "school", "store"]
}*/
}
