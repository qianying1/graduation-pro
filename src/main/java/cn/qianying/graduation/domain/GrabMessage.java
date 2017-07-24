package cn.qianying.graduation.domain;

public class GrabMessage {

	private Integer msgId;
	private String videoName;
	private String isPlay;
	private String evalGrade;
	private String likeIp;
	private String userComment;

	public GrabMessage() {
		super();

	}

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getIsPlay() {
		return isPlay;
	}

	public void setIsPlay(String isPlay) {
		this.isPlay = isPlay;
	}

	public String getEvalGrade() {
		return evalGrade;
	}

	public void setEvalGrade(String evalGrade) {
		this.evalGrade = evalGrade;
	}

	public String getLikeIp() {
		return likeIp;
	}

	public void setLikeIp(String likeIp) {
		this.likeIp = likeIp;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

}
