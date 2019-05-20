class Solution {
	List<List<Integer>> al = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<Integer>();

	public List<List<Integer>> subsets(int[] nums) {
		if (nums == null || nums.length == 0) {
			return al;
		}
		process(nums, 0);
		return al;
	}

	public void process(int[] nums, int i) {
		if (i == nums.length) {
			al.add(new ArrayList<Integer>(list));
			return;
		}

		process(nums, i + 1);

		list.add(nums[i]);
		process(nums, i + 1);

		list.remove(list.size() - 1);
	}

}

//写法二：（两种写法都行）
	public void process(int[] nums, int i) {
		if (i == nums.length) {
			al.add(new ArrayList<Integer>(list));
			return;
		}

		list.add(nums[i]);
		process(nums, i + 1);

		list.remove(list.size() - 1);
		process(nums, i + 1);
	}

//for循环中的dfs写法：
class Solution {
    List<List<Integer>> al = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null||nums.length==0) {
            return al;
        }
        //Arrays.sort(nums);
        process(nums, 0);
        return al;
    }
    
    public void process(int[] nums, int index) {
        al.add(new ArrayList<>(list));            //dfs中的每个当前节点都记录到结果中！！！！！！！！！！！
        for(int i=index;i<nums.length;i++) {
            list.add(nums[i]);
            process(nums, i+1);
            list.remove(list.size()-1);
        }
    }
}
