public interface Master {
    public default int guess(String guess, String secret) {
        int matches = 0;
        for(int i = 0; i < guess.length(); i ++){
            if(guess.charAt(i) == secret.charAt(i)){
                matches ++;
            }
        }

        return matches;
    }
}
