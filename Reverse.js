const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question("Enter a sentence: ", function(sentence) {
  const words = sentence.split(' ');
  const reversedWords = words.map(word => {
    return word.split('').reverse().join('');
  });
  reversedWords.sort((a, b) => b.localeCompare(a));
  const reversedSentence = reversedWords.join(' ');

  console.log("Original Sentence: " + sentence);
  console.log("Reversed Sentence: " + reversedSentence);

  rl.close();
});

rl.on('close', function() {
  console.log("Program ended.");
});
