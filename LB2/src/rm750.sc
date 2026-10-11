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
			sel_198: 5 0 0 1 0 0
			sel_205: 1 4 0 0 1 0 17
			sel_205: 2 4 0 0 2 0 34
			sel_205: 3 4 0 0 3 112 34
			sel_205: 4 4 0 0 4 0 51
			sel_205: 5 4 0 0 5 112 51
			sel_205: 6 4 0 0 6 0 68
			sel_205: 7 4 0 0 7 0 85
			sel_205: 8 4 0 0 8 112 68
			sel_205: 9 4 0 0 9 0 102
			sel_205: 10 4 0 0 10 0 119
			sel_205: 11 4 0 0 11 0 136
			sel_205: 12 4 0 0 12 0 153
			sel_110:
		)
	)
)

(procedure (localproc_1)
	(= local2
		(Print
			sel_198: 5 0 0 2 0 0
			sel_205: 1 6 0 0 1 0 17
			sel_205: 2 6 0 0 2 96 17
			sel_205: 3 6 0 0 3 0 34
			sel_205: 4 6 0 0 4 80 34
			sel_205: 5 6 0 0 5 0 51
			sel_205: 6 6 0 0 6 80 51
			sel_205: 7 6 0 0 7 0 68
			sel_205: 8 6 0 0 8 0 85
			sel_205: 9 6 0 0 9 0 102
			sel_205: 10 6 0 0 10 0 119
			sel_205: 11 6 0 0 11 0 136
			sel_205: 12 6 0 0 12 0 153
			sel_205: 13 6 0 0 13 80 153
			sel_110:
		)
	)
)

(procedure (localproc_2)
	(return (and (or (gEgo sel_238: 11) (IsFlag 155)) 1))
)

(procedure (localproc_3)
	(return
		(and
			(localproc_2)
			(or (gEgo sel_238: 24) (IsFlag 183))
			(gEgo sel_238: 20)
			(gEgo sel_238: 27)
			(gEgo sel_238: 7)
			(gEgo sel_238: 10)
			(or (gEgo sel_238: 29) (IsFlag 170))
			(gEgo sel_238: 26)
			(gEgo sel_238: 21)
			(gEgo sel_238: 30)
			(gEgo sel_238: 17)
			(gEgo sel_238: 31)
			(gEgo sel_238: 25)
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
		sel_20 {rm750}
		sel_142 {rm750}
		sel_214 0
		sel_213 -1
		sel_28 750
		sel_340 10
		sel_343 15
		sel_107 0
		sel_108 160
	)

	(method (sel_110)
		(LoadMany rsPIC 760)
		(LoadMany rsSOUND 760 120)
		(LoadMany rsVIEW 1750 752 753 760)
		(SetFlag 147)
		(super sel_110:)
		(gEgo sel_584: 0)
		(gTheIconBar sel_233:)
		(gGameMusic1 sel_40: 120 sel_99: 1 sel_3: -1 sel_39:)
		(reporters sel_110:)
		(reporterHeads sel_110:)
		(r_arm sel_110: sel_161: RandCycle sel_244: 48)
		(l_arm sel_110: sel_161: RandCycle sel_244: 48)
		(gCurRoom sel_146: sBeforeAsking)
	)

	(method (sel_111)
		(gGameMusic1 sel_170: 0 30 12 1)
		(super sel_111: &rest)
	)
)

(instance sBeforeAsking of Script
	(properties
		sel_20 {sBeforeAsking}
		sel_42 {sBeforeAsking}
		sel_29 0
		sel_134 -1
	)

	(method (sel_144 param1)
		(switch (= sel_134 param1)
			(0
				(gGame sel_587:)
				(= sel_137 2)
			)
			(1
				(gGame sel_197: 999)
				(gMessager sel_295: 2 0 0 0 self)
			)
			(2
				(= sel_65 sFirstFive)
				(self sel_111:)
			)
		)
	)
)

(instance sFirstFive of Script
	(properties
		sel_20 {sFirstFive}
		sel_42 {sFirstFive}
		sel_29 0
		sel_134 -1
	)

	(method (sel_144 param1)
		(switch (= sel_134 param1)
			(0
				(if (== local0 1)
					(Print
						sel_30: 0
						sel_198:
							{REQUIRED CASE FINDINGS\n\nQuestions 1 through 11 determine the coroner's conclusions about the murders and the theft of the Dagger of Amon Ra.}
						sel_110:
					)
				)
				(gMessager sel_295: 1 0 0 local0 self)
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
					(self sel_144: 0)
				else
					(= sel_137 2)
				)
			)
			(2
				(if (IsFlag 147)
					(= sel_65 sSixToNine)
				else
					(= local4 0)
					(= sel_65 sTenOn)
				)
				(self sel_111:)
			)
		)
	)
)

(instance sSixToNine of Script
	(properties
		sel_20 {sSixToNine}
		sel_42 {sSixToNine}
		sel_29 0
		sel_134 -1
	)

	(method (sel_144 param1)
		(switch (= sel_134 param1)
			(0
				(= local0 6)
				(= sel_137 1)
			)
			(1
				(gMessager sel_295: 1 0 0 local0 self)
			)
			(2
				(localproc_0)
				(switch local0
					(6
						(if (!= local1 1)
							(= local4 0)
							(self sel_144: 4)
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
					(self sel_144: 1)
				else
					(= sel_137 1)
				)
			)
			(3
				(localproc_1)
				(if (and (!= local2 9) (!= local2 10))
					(= local4 0)
				)
				(= sel_137 1)
			)
			(4
				(= sel_65 sTenOn)
				(self sel_111:)
			)
		)
	)
)

(instance sTenOn of Script
	(properties
		sel_20 {sTenOn}
		sel_42 {sTenOn}
		sel_29 0
		sel_134 -1
	)

	(method (sel_144 param1)
		(switch (= sel_134 param1)
			(0
				(= local0 10)
				(= sel_137 1)
			)
			(1
				(gMessager sel_295: 1 0 0 local0 self)
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
						(= sel_137 1)
					)
					(11
						(if (!= local1 9)
							(= local5 0)
						)
						(++ local0)
						(= sel_137 1)
					)
				)
			)
			(3
				(if (>= local0 12)
					(= sel_65 sBonusQuestions)
					(self sel_111:)
				else
					(self sel_144: 1)
				)
			)
		)
	)
)

(instance sBonusQuestions of Script
	(properties
		sel_20 {sBonusQuestions}
		sel_42 {sBonusQuestions}
		sel_29 0
		sel_134 -1
	)

	(method (sel_144 param1)
		(switch (= sel_134 param1)
			(0
				(Print
					sel_30: 0
					sel_198:
						{BONUS MUSEUM INQUIRIES\n\nQuestions 12 through 16 concern the art-theft ring and the High Priest. They are optional and do not affect Laura's final case result.}
					sel_110:
				)
				(= sel_137 1)
			)
			(1
				(gMessager sel_295: 1 0 0 local0 self)
			)
			(2
				(localproc_0)
				(switch local0
					(12
						(if (!= local1 11)
							(= local0 15)
							(gMessager sel_295: 8 0 6 0 self)
						else
							(++ local0)
							(gMessager sel_295: 8 0 5 0 self)
						)
					)
					(13
						(if (!= local1 6)
							(= local0 15)
							(gMessager sel_295: 8 0 6 0 self)
						else
							(++ local0)
							(gMessager sel_295: 8 0 5 0 self)
						)
					)
					(14
						(if (!= local1 12)
							(gMessager sel_295: 8 0 6 0 self)
						else
							(gMessager sel_295: 8 0 5 0 self)
						)
						(++ local0)
					)
					(15
						(if (!= local1 8)
							(gMessager sel_295: 9 0 0 0 self)
						else
							(gMessager sel_295: 9 0 7 0 self)
						)
						(++ local0)
					)
					(16
						(if (!= local1 5)
							(gMessager sel_295: 10 0 0 0 self)
						else
							(gMessager sel_295: 10 0 8 0 self)
						)
						(++ local0)
					)
				)
			)
			(3
				(if (> local0 16)
					(= sel_137 1)
				else
					(self sel_144: 1)
				)
			)
			(4
				(= sel_65 sEvidenceReview)
				(self sel_111:)
			)
		)
	)
)

(instance sEvidenceReview of Script
	(properties
		sel_20 {sEvidenceReview}
		sel_42 {sEvidenceReview}
		sel_29 0
		sel_134 -1
	)

	(method (sel_144 param1)
		(switch (= sel_134 param1)
			(0
				(if (gEgo sel_238: 20)
					(gGame sel_87: 1 180)
					(Print
						sel_30: 0
						sel_198:
							{The Ankh medallion's initials point rather neatly at Dr. Smith, Miss Bow--too neatly. In light of the case you have established, I will record it as a deliberate attempt to frame him, not as proof of his guilt.}
						sel_110:
					)
				)
				(if (gEgo sel_238: 21)
					(gGame sel_87: 1 181)
					(Print
						sel_30: 0
						sel_198:
							{Pippin's appointment list is useful timeline evidence. It tells us who was expected in the Egyptian Room, but an appointment alone proves neither presence nor guilt. Your care in preserving it deserves credit.}
						sel_110:
					)
				)
				(if (and (IsFlag 179) (gEgo sel_238: 30))
					(gGame sel_87: 1 182)
					(Print
						sel_30: 0
						sel_198:
							{The bloody high-heeled footprint at Pippin's body and the woman's shoe form a conspicuous trail toward Yvette. Against the other evidence, that trail looks planted. You were right to document both clues without mistaking them for a verdict.}
						sel_110:
					)
				)
				(= sel_65 sAfterQuestions)
				(self sel_111:)
			)
		)
	)
)

(instance sAfterQuestions of Script
	(properties
		sel_20 {sAfterQuestions}
		sel_42 {sAfterQuestions}
		sel_29 0
		sel_134 -1
	)

	(method (sel_144 param1 &tmp [temp0 100])
		(switch (= sel_134 param1)
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
					((gEgo sel_238: 11)
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
					(tut sel_110:)
					(gMessager sel_295: 7 0 0 0 self)
				else
					(self sel_144: 3)
				)
			)
			(1
				(tut sel_312: MoveTo -10 113 self)
			)
			(2
				(gMessager sel_295: 7 0 9 0 self)
			)
			(3
				(gMessager sel_295: 3 0 local3 0 self)
			)
			(4
				(cond
					((== global126 1)
						(gGameMusic2 sel_40: 750 sel_99: 5 sel_3: 1 sel_39:)
						(reporterHeads sel_161: End self)
					)
					((or (== global126 2) (== global126 4))
						(gGameMusic2 sel_40: 751 sel_99: 5 sel_3: 1 sel_39:)
						(reporterHeads sel_161: End self)
					)
					(else
						(gGameMusic2 sel_40: 752 sel_99: 5 sel_3: 1 sel_39:)
						(= sel_138 4)
					)
				)
			)
			(5
				(if (== global126 3)
					(self sel_144: 8)
				else
					(reporterHeads sel_155: 2 sel_156: 0 sel_161: End self)
				)
			)
			(6
				(reporterHeads sel_155: 3 sel_156: 0 sel_161: End self)
			)
			(7
				(reporterHeads sel_156: 0 sel_155: 4 sel_161: Fwd)
				(= sel_138 4)
			)
			(8
				(paper sel_110: sel_102:)
				(headline
					sel_110:
					sel_3:
						(if (OneOf (localproc_4) 2 4)
							2
						else
							(localproc_4)
						)
					sel_102:
				)
				(gCurRoom sel_417: 780)
				(gCast sel_119: 102)
				(= sel_137 2)
				(gGameMusic1 sel_170: 0 12 30 1)
			)
			(9
				(gGameMusic1 sel_40: 760 sel_99: 1 sel_3: 1 sel_39:)
				(paper sel_216:)
				(paper sel_161: End self)
			)
			(10
				(gCurRoom sel_417: 760 100)
				(paper sel_102:)
				(= sel_137 1)
			)
			(11
				(headline sel_216:)
				(= sel_138 4)
			)
			(12
				(= global126 (localproc_4))
				(gCurRoom
					sel_399:
						(switch global126
							(1 770)
							(2 775)
							(3 785)
							(4 770)
						)
				)
				(self sel_111:)
			)
		)
	)
)

(instance tut of Actor
	(properties
		sel_20 {tut}
		sel_1 {tut}
		sel_0 -60
		sel_82 113
		sel_214 0
		sel_6 -1
		sel_301 0
		sel_299 26505
		sel_302 0
		sel_303 26505
		sel_52 0
		sel_2 2
		sel_3 753
		sel_104 0
		sel_244 128
		sel_142 6
		sel_15 0
		sel_249 -32768
		sel_51 0
		sel_323 3
		sel_53 770
		sel_324 6
	)
)

(instance reporterHeads of Prop
	(properties
		sel_20 {reporterHeads}
		sel_1 {reporterHeads}
		sel_0 61
		sel_82 73
		sel_214 0
		sel_6 -1
		sel_301 0
		sel_299 26505
		sel_302 0
		sel_303 26505
		sel_52 0
		sel_2 2
		sel_3 752
		sel_4 1
		sel_10 16384
		sel_104 0
		sel_244 128
		sel_142 6
	)
)

(instance paper of Prop
	(properties
		sel_20 {paper}
		sel_1 {paper}
		sel_0 154
		sel_82 96
		sel_214 0
		sel_6 -1
		sel_301 0
		sel_299 26505
		sel_302 0
		sel_303 26505
		sel_52 0
		sel_2 2
		sel_3 760
		sel_104 0
		sel_244 128
		sel_142 6
	)
)

(instance r_arm of Prop
	(properties
		sel_20 {r\_arm}
		sel_1 {r\_arm}
		sel_0 255
		sel_82 91
		sel_214 0
		sel_6 -1
		sel_301 0
		sel_299 26505
		sel_302 0
		sel_303 26505
		sel_52 0
		sel_2 2
		sel_3 752
		sel_4 5
		sel_104 0
		sel_244 128
		sel_142 6
	)
)

(instance l_arm of Prop
	(properties
		sel_20 {l\_arm}
		sel_1 {l\_arm}
		sel_0 280
		sel_82 90
		sel_214 0
		sel_6 -1
		sel_301 0
		sel_299 26505
		sel_302 0
		sel_303 26505
		sel_52 0
		sel_2 2
		sel_3 752
		sel_4 6
		sel_104 0
		sel_244 128
		sel_142 6
	)
)

(instance reporters of View
	(properties
		sel_20 {reporters}
		sel_1 {reporters}
		sel_0 62
		sel_82 72
		sel_214 0
		sel_6 -1
		sel_301 0
		sel_299 26505
		sel_302 0
		sel_303 26505
		sel_52 0
		sel_2 2
		sel_3 752
		sel_14 0
		sel_10 257
		sel_104 0
	)
)

(instance headline of View
	(properties
		sel_20 {headline}
		sel_1 {headline}
		sel_0 33
		sel_82 59
		sel_214 0
		sel_6 -1
		sel_301 0
		sel_299 26505
		sel_302 0
		sel_303 26505
		sel_52 0
		sel_2 2
		sel_3 760
		sel_14 0
		sel_10 257
		sel_104 0
	)
)

(instance Coroner of Talker
	(properties
		sel_20 {Coroner}
		sel_1 {Coroner}
		sel_0 0
		sel_214 0
		sel_6 -1
		sel_301 0
		sel_299 26505
		sel_302 0
		sel_303 26505
		sel_52 0
		sel_2 2
		sel_3 1750
		sel_4 3
		sel_104 0
		sel_244 128
		sel_142 6
		sel_291 0
		sel_139 1
		sel_537 0
		sel_538 150
		sel_26 0
		sel_541 15
		sel_550 10
		sel_551 10
		sel_552 0
	)

	(method (sel_110)
		(= sel_539 gUserFont)
		(super sel_110: coronerBust coronerEyes coronerMouth &rest)
	)
)

(instance coronerBust of Prop
	(properties
		sel_20 {coronerBust}
		sel_1 {coronerBust}
		sel_214 0
		sel_6 -1
		sel_301 0
		sel_299 26505
		sel_302 0
		sel_303 26505
		sel_52 0
		sel_2 2
		sel_3 1750
		sel_4 1
		sel_104 0
		sel_244 128
		sel_142 6
	)
)

(instance coronerEyes of Prop
	(properties
		sel_20 {coronerEyes}
		sel_1 {coronerEyes}
		sel_214 0
		sel_6 -1
		sel_7 77
		sel_8 263
		sel_301 0
		sel_299 26505
		sel_302 0
		sel_303 26505
		sel_52 0
		sel_2 2
		sel_3 1750
		sel_4 2
		sel_104 0
		sel_244 128
		sel_142 6
	)
)

(instance coronerMouth of Prop
	(properties
		sel_20 {coronerMouth}
		sel_1 {coronerMouth}
		sel_214 0
		sel_6 -1
		sel_7 80
		sel_8 264
		sel_301 0
		sel_299 26505
		sel_302 0
		sel_303 26505
		sel_52 0
		sel_2 2
		sel_3 1750
		sel_104 0
		sel_244 128
		sel_142 6
	)
)
