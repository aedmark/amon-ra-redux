;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 750)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Talker)
(use RandCycle)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm750 0
	Coroner 21
)

(local
	local0 = 1
	local1
	local2
	local3
	local4 = 1
	local5 = 1
)

(procedure (localproc_0)
	(= local1
		(Print
			addText: 5 0 0 1 0 0
			addButton: 1 4 0 0 1 0 17
			addButton: 2 4 0 0 2 0 34
			addButton: 3 4 0 0 3 112 34
			addButton: 4 4 0 0 4 0 51
			addButton: 5 4 0 0 5 112 51
			addButton: 6 4 0 0 6 0 68
			addButton: 7 4 0 0 7 0 85
			addButton: 8 4 0 0 8 112 68
			addButton: 9 4 0 0 9 0 102
			addButton: 10 4 0 0 10 0 119
			addButton: 11 4 0 0 11 0 136
			addButton: 12 4 0 0 12 0 153
			init:
		)
	)
)

(procedure (localproc_1)
	(= local2
		(Print
			addText: 5 0 0 2 0 0
			addButton: 1 6 0 0 1 0 17
			addButton: 2 6 0 0 2 96 17
			addButton: 3 6 0 0 3 0 34
			addButton: 4 6 0 0 4 80 34
			addButton: 5 6 0 0 5 0 51
			addButton: 6 6 0 0 6 80 51
			addButton: 7 6 0 0 7 0 68
			addButton: 8 6 0 0 8 0 85
			addButton: 9 6 0 0 9 0 102
			addButton: 10 6 0 0 10 0 119
			addButton: 11 6 0 0 11 0 136
			addButton: 12 6 0 0 12 0 153
			addButton: 13 6 0 0 13 80 153
			init:
		)
	)
)

(procedure (localproc_2)
	(return (and (or (gEgo has: 11) (IsFlag 155)) 1))
)

(procedure (localproc_3)
	(return
		(and
			(localproc_2)
			(or (gEgo has: 24) (IsFlag 183))
			(gEgo has: 20)
			(gEgo has: 27)
			(gEgo has: 7)
			(gEgo has: 10)
			(or (gEgo has: 29) (IsFlag 170))
			(gEgo has: 26)
			(gEgo has: 21)
			(gEgo has: 30)
			(gEgo has: 17)
			(gEgo has: 31)
			(gEgo has: 25)
			1
		)
	)
)

(procedure (localproc_4)
	(return
		(cond
			((OneOf global126 1 4)
				(if (localproc_2) 1 else 4)
			)
			((localproc_2) 2)
			(else 3)
		)
	)
)

(instance rm750 of LBRoom
	(properties
		name {rm750}
		picture 750
		style 10
	)

	(method (init)
		(LoadMany rsPIC 760)
		(LoadMany rsSOUND 760 120)
		(LoadMany rsVIEW 1750 752 753 760)
		(SetFlag 147)
		(super init:)
		(gEgo wearingGown: 0)
		(gTheIconBar disable:)
		(gGameMusic1 number: 120 flags: 1 loop: -1 play:)
		(reporters init:)
		(reporterHeads init:)
		(r_arm init: setCycle: RandCycle cycleSpeed: 48)
		(l_arm init: setCycle: RandCycle cycleSpeed: 48)
		(gCurRoom setScript: sBeforeAsking)
	)

	(method (dispose)
		(gGameMusic1 fade: 0 30 12 1)
		(super dispose: &rest)
	)
)

(instance sBeforeAsking of Script
	(properties
		name {sBeforeAsking}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGame setCursor: 999)
				(gMessager say: 2 0 0 0 self)
			)
			(2
				(= next sFirstFive)
				(self dispose:)
			)
		)
	)
)

(instance sFirstFive of Script
	(properties
		name {sFirstFive}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(if (== local0 1)
					(Print
						font: 0
						addText:
							{REQUIRED CASE FINDINGS\n\nQuestions 1 through 11 determine the coroner's conclusions about the murders and the theft of the Dagger of Amon Ra.}
						init:
					)
				)
				(gMessager say: 1 0 0 local0 self)
			)
			(1
				(localproc_0)
				(if (!= local1 9)
					(= local4 0)
				)
				(localproc_1)
				(cond
					((!= local0 4)
						(if (and (!= local2 9) (!= local2 10))
							(= local4 0)
						)
					)
					((and (!= local2 6) (!= local2 3))
						(= local4 0)
					)
				)
				(if (< (++ local0) 6)
					(self changeState: 0)
				else
					(= cycles 2)
				)
			)
			(2
				(if (IsFlag 147)
					(= next sSixToNine)
				else
					(= local4 0)
					(= next sTenOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance sSixToNine of Script
	(properties
		name {sSixToNine}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= local0 6)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 0 local0 self)
			)
			(2
				(localproc_0)
				(switch local0
					(6
						(if (!= local1 1)
							(= local4 0)
							(self changeState: 4)
						else
							(++ local0)
						)
					)
					(9
						(if (!= local1 9)
							(= local4 0)
						)
						(++ local0)
					)
					(else
						(if (!= local1 6)
							(= local4 0)
						)
						(++ local0)
					)
				)
				(if (< local0 10)
					(self changeState: 1)
				else
					(= cycles 1)
				)
			)
			(3
				(localproc_1)
				(if (and (!= local2 9) (!= local2 10))
					(= local4 0)
				)
				(= cycles 1)
			)
			(4
				(= next sTenOn)
				(self dispose:)
			)
		)
	)
)

(instance sTenOn of Script
	(properties
		name {sTenOn}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= local0 10)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 0 local0 self)
			)
			(2
				(localproc_0)
				(switch local0
					(10
						(if (!= local1 6)
							(= local5 0)
							(+= local0 2)
						else
							(++ local0)
						)
						(= cycles 1)
					)
					(11
						(if (!= local1 9)
							(= local5 0)
						)
						(++ local0)
						(= cycles 1)
					)
				)
			)
			(3
				(if (>= local0 12)
					(= next sBonusQuestions)
					(self dispose:)
				else
					(self changeState: 1)
				)
			)
		)
	)
)

(instance sBonusQuestions of Script
	(properties
		name {sBonusQuestions}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(Print
					font: 0
					addText:
						{BONUS MUSEUM INQUIRIES\n\nQuestions 12 through 16 concern the art-theft ring and the High Priest. They are optional and do not affect Laura's final case result.}
					init:
				)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 0 local0 self)
			)
			(2
				(localproc_0)
				(switch local0
					(12
						(if (!= local1 11)
							(= local0 15)
							(gMessager say: 8 0 6 0 self)
						else
							(++ local0)
							(gMessager say: 8 0 5 0 self)
						)
					)
					(13
						(if (!= local1 6)
							(= local0 15)
							(gMessager say: 8 0 6 0 self)
						else
							(++ local0)
							(gMessager say: 8 0 5 0 self)
						)
					)
					(14
						(if (!= local1 12)
							(gMessager say: 8 0 6 0 self)
						else
							(gMessager say: 8 0 5 0 self)
						)
						(++ local0)
					)
					(15
						(if (!= local1 8)
							(gMessager say: 9 0 0 0 self)
						else
							(gMessager say: 9 0 7 0 self)
						)
						(++ local0)
					)
					(16
						(if (!= local1 5)
							(gMessager say: 10 0 0 0 self)
						else
							(gMessager say: 10 0 8 0 self)
						)
						(++ local0)
					)
				)
			)
			(3
				(if (> local0 16)
					(= cycles 1)
				else
					(self changeState: 1)
				)
			)
			(4
				(= next sEvidenceReview)
				(self dispose:)
			)
		)
	)
)

(instance sEvidenceReview of Script
	(properties
		name {sEvidenceReview}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(if (gEgo has: 20)
					(gGame points: 1 180)
					(Print
						font: 0
						addText:
							{The Ankh medallion's initials point rather neatly at Dr. Smith, Miss Bow--too neatly. In light of the case you have established, I will record it as a deliberate attempt to frame him, not as proof of his guilt.}
						init:
					)
				)
				(if (gEgo has: 21)
					(gGame points: 1 181)
					(Print
						font: 0
						addText:
							{Pippin's appointment list is useful timeline evidence. It tells us who was expected in the Egyptian Room, but an appointment alone proves neither presence nor guilt. Your care in preserving it deserves credit.}
						init:
					)
				)
				(if (and (IsFlag 179) (gEgo has: 30))
					(gGame points: 1 182)
					(Print
						font: 0
						addText:
							{The bloody high-heeled footprint at Pippin's body and the woman's shoe form a conspicuous trail toward Yvette. Against the other evidence, that trail looks planted. You were right to document both clues without mistaking them for a verdict.}
						init:
					)
				)
				(= next sAfterQuestions)
				(self dispose:)
			)
		)
	)
)

(instance sAfterQuestions of Script
	(properties
		name {sAfterQuestions}
	)

	(method (changeState param1 &tmp [temp0 100])
		(switch (= state param1)
			(0
				(cond
					((and (localproc_3) local4 local5)
						(= local3 2)
					)
					((and (localproc_3) local4)
						(= local3 1)
					)
					(local5
						(= local3 4)
					)
					((gEgo has: 11)
						(= local3 10)
					)
					(else
						(= local3 3)
					)
				)
				(cond
					((and (localproc_3) local4 local5)
						(= global126 1)
					)
					((and (localproc_3) local4)
						(= global126 4)
					)
					(local5
						(= global126 2)
					)
					(else
						(= global126 3)
					)
				)
				(if (or (== local3 1) (== local3 2))
					(tut init:)
					(gMessager say: 7 0 0 0 self)
				else
					(self changeState: 3)
				)
			)
			(1
				(tut setMotion: MoveTo -10 113 self)
			)
			(2
				(gMessager say: 7 0 9 0 self)
			)
			(3
				(gMessager say: 3 0 local3 0 self)
			)
			(4
				(cond
					((== global126 1)
						(gGameMusic2 number: 750 flags: 5 loop: 1 play:)
						(reporterHeads setCycle: End self)
					)
					((or (== global126 2) (== global126 4))
						(gGameMusic2 number: 751 flags: 5 loop: 1 play:)
						(reporterHeads setCycle: End self)
					)
					(else
						(gGameMusic2 number: 752 flags: 5 loop: 1 play:)
						(= seconds 4)
					)
				)
			)
			(5
				(if (== global126 3)
					(self changeState: 8)
				else
					(reporterHeads setLoop: 2 setCel: 0 setCycle: End self)
				)
			)
			(6
				(reporterHeads setLoop: 3 setCel: 0 setCycle: End self)
			)
			(7
				(reporterHeads setCel: 0 setLoop: 4 setCycle: Fwd)
				(= seconds 4)
			)
			(8
				(paper init: hide:)
				(headline
					init:
					loop:
						(if (OneOf (localproc_4) 2 4)
							2
						else
							(localproc_4)
						)
					hide:
				)
				(gCurRoom drawPic: 780)
				(gCast eachElementDo: 102)
				(= cycles 2)
				(gGameMusic1 fade: 0 12 30 1)
			)
			(9
				(gGameMusic1 number: 760 flags: 1 loop: 1 play:)
				(paper show:)
				(paper setCycle: End self)
			)
			(10
				(gCurRoom drawPic: 760 100)
				(paper hide:)
				(= cycles 1)
			)
			(11
				(headline show:)
				(= seconds 4)
			)
			(12
				(= global126 (localproc_4))
				(gCurRoom
					newRoom:
						(switch global126
							(1 770)
							(2 775)
							(3 785)
							(4 770)
						)
				)
				(self dispose:)
			)
		)
	)
)

(instance tut of Actor
	(properties
		name {tut}
		x -60
		y 113
		view 753
	)
)

(instance reporterHeads of Prop
	(properties
		name {reporterHeads}
		x 61
		y 73
		view 752
		loop 1
		signal 16384
	)
)

(instance paper of Prop
	(properties
		name {paper}
		x 154
		y 96
		view 760
	)
)

(instance r_arm of Prop
	(properties
		name {r\_arm}
		x 255
		y 91
		view 752
		loop 5
	)
)

(instance l_arm of Prop
	(properties
		name {l\_arm}
		x 280
		y 90
		view 752
		loop 6
	)
)

(instance reporters of View
	(properties
		name {reporters}
		x 62
		y 72
		view 752
	)
)

(instance headline of View
	(properties
		name {headline}
		x 33
		y 59
		view 760
	)
)

(instance Coroner of Talker
	(properties
		name {Coroner}
		x 0
		y 0
		view 1750
		loop 3
		talkWidth 150
		back 15
		textX 10
		textY 10
	)

	(method (init)
		(= font gUserFont)
		(super init: coronerBust coronerEyes coronerMouth &rest)
	)
)

(instance coronerBust of Prop
	(properties
		name {coronerBust}
		view 1750
		loop 1
	)
)

(instance coronerEyes of Prop
	(properties
		name {coronerEyes}
		nsTop 77
		nsLeft 263
		view 1750
		loop 2
	)
)

(instance coronerMouth of Prop
	(properties
		name {coronerMouth}
		nsTop 80
		nsLeft 264
		view 1750
	)
)
