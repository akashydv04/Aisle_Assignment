package com.example.aisleassignment.data.response

data class NotesResponse(
    val invites: Invites,
    val likes: Likes
) {
    data class Invites(
        val pending_invitations_count: Int,
        val profiles: List<Profile>,
        val totalPages: Int
    ) {
        data class Profile(
            val approved_time: Double,
            val disapproved_time: Double,
            val general_information: GeneralInformation,
            val has_active_subscription: Boolean,
            val icebreakers: Any,
            val instagram_images: Any,
            val is_facebook_data_fetched: Boolean,
            val last_seen: Any,
            val last_seen_window: String,
            val lat: String,
            val lng: String,
            val meetup: Any,
            val online_code: Int,
            val photos: List<Photo>,
            val preferences: List<Preference>,
            val profile_data_list: List<ProfileData>,
            val show_concierge_badge: Boolean,
            val story: Any,
            val user_interests: List<Any>,
            val verification_status: String,
            val work: Work
        ) {
            data class GeneralInformation(
                val age: Int,
                val cast: Any,
                val date_of_birth: String,
                val date_of_birth_v1: String,
                val diet: Any,
                val drinking_v1: DrinkingV1,
                val faith: Faith,
                val first_name: String,
                val gender: String,
                val height: Int,
                val kid: Any,
                val location: Location,
                val marital_status_v1: MaritalStatusV1,
                val mbti: Any,
                val mother_tongue: MotherTongue,
                val pet: Any,
                val politics: Any,
                val ref_id: String,
                val settle: Any,
                val smoking_v1: SmokingV1,
                val sun_sign_v1: SunSignV1
            ) {
                data class DrinkingV1(
                    val id: Int,
                    val name: String,
                    val name_alias: String
                )

                data class Faith(
                    val id: Int,
                    val name: String
                )

                data class Location(
                    val full: String,
                    val summary: String
                )

                data class MaritalStatusV1(
                    val id: Int,
                    val name: String,
                    val preference_only: Boolean
                )

                data class MotherTongue(
                    val id: Int,
                    val name: String
                )

                data class SmokingV1(
                    val id: Int,
                    val name: String,
                    val name_alias: String
                )

                data class SunSignV1(
                    val id: Int,
                    val name: String
                )
            }

            data class Photo(
                val photo: String,
                val photo_id: Int,
                val selected: Boolean,
                val status: String
            )

            data class Preference(
                val answer_id: Int,
                val id: Int,
                val preference_question: PreferenceQuestion,
                val value: Int
            ) {
                data class PreferenceQuestion(
                    val first_choice: String,
                    val second_choice: String
                )
            }

            data class ProfileData(
                val invitation_type: String,
                val preferences: List<Preference>,
                val question: String
            ) {
                data class Preference(
                    val answer: String,
                    val answer_id: Int,
                    val first_choice: String,
                    val second_choice: String
                )
            }

            data class Work(
                val experience_v1: ExperienceV1,
                val field_of_study_v1: FieldOfStudyV1,
                val highest_qualification_v1: HighestQualificationV1,
                val industry_v1: IndustryV1,
                val monthly_income_v1: Any
            ) {
                data class ExperienceV1(
                    val id: Int,
                    val name: String,
                    val name_alias: String
                )

                data class FieldOfStudyV1(
                    val id: Int,
                    val name: String
                )

                data class HighestQualificationV1(
                    val id: Int,
                    val name: String,
                    val preference_only: Boolean
                )

                data class IndustryV1(
                    val id: Int,
                    val name: String,
                    val preference_only: Boolean
                )
            }
        }
    }

    data class Likes(
        val can_see_profile: Boolean,
        val likes_received_count: Int,
        val profiles: List<Profile>
    ) {
        data class Profile(
            val avatar: String,
            val first_name: String
        )
    }
}