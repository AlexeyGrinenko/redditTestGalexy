package s.com.reddittestgalexy.remote.model

import com.google.gson.annotations.SerializedName

data class RedditDataGson (
    @SerializedName("approved_at_utc")
    var approvedAtUtc: Long?,
    @SerializedName("subreddit")
    var subreddit: String?,
    @SerializedName("selftext")
    var selftext: String?,
    @SerializedName("author_fullname")
    var authorFullname: String?,
    @SerializedName("saved")
    var saved: Boolean?,
    @SerializedName("mod_reason_title")
    var modReasonTitle: String?,
    @SerializedName("gilded")
    var gilded: Int?,
    @SerializedName("clicked")
    var clicked: Boolean?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("subreddit_name_prefixed")
    var subredditNamePrefixed: String?,
    @SerializedName("hidden")
    var hidden: Boolean?,
    @SerializedName("pwls")
    var pwls: Int?,
    @SerializedName("downs")
    var downs: Int?,
    @SerializedName("hide_score")
    var hideScore: Boolean?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("quarantine")
    var quarantine: Boolean?,
    @SerializedName("link_flair_text_color")
    var linkFlairTextColor: String?,
    @SerializedName("subreddit_type")
    var subredditType: String?,
    @SerializedName("ups")
    var ups: Int?,
    @SerializedName("total_awards_received")
    var totalAwardsReceived: Int?,
    @SerializedName("thumbnail_width")
    var thumbnailWidth: Int?,
    @SerializedName("thumbnail_height")
    var thumbnailHeight: Int?,
    @SerializedName("author_flair_template_id")
    var authorFlairTemplateId: String?,
    @SerializedName("is_original_content")
    var isOriginalContent: Boolean?,
//    @SerializedName("secure_media")
//    var secureMedia: String?,
    @SerializedName("is_reddit_media_domain")
    var isRedditMediaDomain: Boolean?,
    @SerializedName("is_meta")
    var isMeta: Boolean?,
    @SerializedName("category")
    var category: String?,
    @SerializedName("link_flair_text")
    var linkFlairText: String?,
    @SerializedName("can_mod_post")
    var canModPost: Boolean?,
    @SerializedName("score")
    var score: Int?,
    @SerializedName("approved_by")
    var approvedBy: String?,
    @SerializedName("author_premium")
    var authorPremium: Boolean?,
    @SerializedName("thumbnail")
    var thumbnail: String?,
    @SerializedName("edited")
    var edited: String?,
    @SerializedName("author_flair_css_class")
    var authorFlairCssClass: String?,
    @SerializedName("content_categories")
    var contentCategories: List<String>?,
    @SerializedName("is_self")
    var isSelf: Boolean?,
    @SerializedName("created")
    var created: Long?,
    @SerializedName("link_flair_type")
    var linkFlairType: String?,
    @SerializedName("wls")
    var wls: Int?,
    @SerializedName("removed_by_category")
    var removedByCategory: String?,
    @SerializedName("banned_by")
    var bannedBy: String?,
    @SerializedName("author_flair_type")
    var authorFlairType: String?,
    @SerializedName("domain")
    var domain: String?,
    @SerializedName("allow_live_comments")
    var allowLiveComments: Boolean?,
    @SerializedName("selftext_html")
    var selftextHtml: String?,
    @SerializedName("likes")
    var likes: Int?,
    @SerializedName("suggested_sort")
    var suggestedSort: String?,
    @SerializedName("banned_at_utc")
    var bannedAtUtc: Long?,
    @SerializedName("view_count")
    var viewCount: Int?,
    @SerializedName("archived")
    var archived: Boolean?,
    @SerializedName("no_follow")
    var noFollow: Boolean?,
    @SerializedName("is_crosspostable")
    var isCrosspostable: Boolean?,
    @SerializedName("pinned")
    var pinned: Boolean?,
    @SerializedName("over_18")
    var over18: Boolean?,
    @SerializedName("media_only")
    var mediaOnly: Boolean?,
    @SerializedName("can_gild")
    var canGild: Boolean?,
    @SerializedName("spoiler")
    var spoiler: Boolean?,
    @SerializedName("locked")
    var locked: Boolean?,
    @SerializedName("author_flair_text")
    var authorFlairText: String?,
    @SerializedName("visited")
    var visited: Boolean?,
    @SerializedName("removed_by")
    var removedBy: String?,
    @SerializedName("num_reports")
    var numReports: Int?,
    @SerializedName("distinguished")
    var distinguished: String?,
    @SerializedName("subreddit_id")
    var subredditId: String?,
    @SerializedName("mod_reason_by")
    var modReasonBy: String?,
    @SerializedName("removal_reason")
    var removalReason: String?,
    @SerializedName("link_flair_background_color")
    var linkFlairBackgroundColor: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("is_robot_indexable")
    var isRobotIndexable: Boolean?,
    @SerializedName("report_reasons")
    var reportReasons: String?,
    @SerializedName("author")
    var author: String?,
    @SerializedName("discussion_type")
    var discussionType: String?,
    @SerializedName("num_comments")
    var numComments: Int?,
    @SerializedName("send_replies")
    var sendReplies: Boolean?,
    @SerializedName("whitelist_status")
    var whitelistStatus: String?,
    @SerializedName("contest_mode")
    var contestMode: Boolean?,
    @SerializedName("author_patreon_flair")
    var authorPatreonFlair: Boolean?,
    @SerializedName("author_flair_text_color")
    var authorFlairTextColor: String?,
    @SerializedName("permalink")
    var permalink: String?,
    @SerializedName("parent_whitelist_status")
    var parentWhitelistStatus: String?,
    @SerializedName("stickied")
    var stickied: Boolean?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("subreddit_subscribers")
    var subredditSubscribers: Int?,
    @SerializedName("created_utc")
    var createdUtc: Long?,
    @SerializedName("num_crossposts")
    var numCrossposts: Int?,
//    @SerializedName("media")
//    var media: String?,
    @SerializedName("is_video")
    var isVideo: Boolean?
    )