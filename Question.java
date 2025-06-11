public class Question{
  private String questionText;
  private String answer;
  private String topic;
  
  public Question(String questionText, String answer, String topic){
    this.questionText = questionText;
    this.answer = answer;
    this.topic = topic;
  }

  public String getQuestionText() {
    return questionText;
  }

  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String toString() {
    return "Question: " + questionText + "\nAnswer: " + answer + "\nTopic: " + topic;
  }
}