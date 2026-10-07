;;; Sierra Script 1.0 - (do not remove this comment)
(script# 750)
(include sci.sh)
(use Main)
(use LBRoom)
(use Print)
(use RTRandCycle)
(use RandCycle)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm750 0
	Coroner 21
)

(local
	local0 =  1
	local1
	local2
	local3
	local4 =  1
	local5 =  1
)
(procedure (localproc_013c)
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

(procedure (localproc_0211)
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

(instance rm750 of LBRoom
	(properties
		sel_20 {rm750}
		sel_408 750
		sel_28 10
	)
	
	(method (sel_110)
		(proc958_0 129 760)
		(proc958_0 132 760 120)
		(proc958_0 128 1750 752 753 760)
		(proc0_3 147)
		(super sel_110:)
		(gEgo sel_584: 0)
		(gIconBar sel_233:)
		(gSel_608 sel_40: 120 sel_99: 1 sel_3: -1 sel_39:)
		(reporters sel_110:)
		(reporterHeads sel_110:)
		(r_arm sel_110: sel_161: RandCycle sel_244: 48)
		(l_arm sel_110: sel_161: RandCycle sel_244: 48)
		(global2 sel_146: sBeforeAsking)
	)
	
	(method (sel_111)
		(gSel_608 sel_170: 0 30 12 1)
		(super sel_111: &rest)
	)
)

(instance sBeforeAsking of Script
	(properties
		sel_20 {sBeforeAsking}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 2)
			)
			(1
				(gGame sel_197: 999)
				(gLb2Messager sel_295: 2 0 0 0 self)
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
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gLb2Messager sel_295: 1 0 0 local0 self)
			)
			(1
				(localproc_013c)
				(if (!= local1 9) (= local4 0))
				(localproc_0211)
				(cond 
					((!= local0 4) (if (and (!= local2 9) (!= local2 10)) (= local4 0)))
					((and (!= local2 6) (!= local2 3)) (= local4 0))
				)
				(if (< (++ local0) 6)
					(self sel_144: 0)
				else
					(= sel_136 2)
				)
			)
			(2
				(if (proc0_2 147)
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
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= local0 6) (= sel_136 1))
			(1
				(gLb2Messager sel_295: 1 0 0 local0 self)
			)
			(2
				(localproc_013c)
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
						(if (!= local1 9) (= local4 0))
						(++ local0)
					)
					(else 
						(if (!= local1 6) (= local4 0))
						(++ local0)
					)
				)
				(if (< local0 10) (self sel_144: 1) else (= sel_136 1))
			)
			(3
				(localproc_0211)
				(if (and (!= local2 9) (!= local2 10)) (= local4 0))
				(= sel_136 1)
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
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= local0 10) (= sel_136 1))
			(1
				(gLb2Messager sel_295: 1 0 0 local0 self)
			)
			(2
				(localproc_013c)
				(switch local0
					(10
						(if (!= local1 6)
							(= local5 0)
							(= local0 (+ local0 2))
						else
							(++ local0)
						)
						(= sel_136 1)
					)
					(11
						(if (!= local1 9) (= local5 0))
						(++ local0)
						(= sel_136 1)
					)
					(12
						(if (!= local1 11)
							(= local0 15)
							(gLb2Messager sel_295: 8 0 6 0 self)
						else
							(++ local0)
							(gLb2Messager sel_295: 8 0 5 0 self)
						)
					)
					(13
						(if (!= local1 6)
							(= local0 15)
							(gLb2Messager sel_295: 8 0 6 0 self)
						else
							(++ local0)
							(gLb2Messager sel_295: 8 0 5 0 self)
						)
					)
					(14
						(if (!= local1 12)
							(gLb2Messager sel_295: 8 0 6 0 self)
						else
							(gLb2Messager sel_295: 8 0 5 0 self)
						)
						(++ local0)
					)
					(15
						(if (!= local1 8)
							(gLb2Messager sel_295: 9 0 0 0 self)
						else
							(gLb2Messager sel_295: 9 0 7 0 self)
						)
						(++ local0)
					)
					(16
						(if (!= local1 5)
							(gLb2Messager sel_295: 10 0 0 0 self)
						else
							(gLb2Messager sel_295: 10 0 8 0 self)
						)
						(++ local0)
					)
				)
			)
			(3
				(if (> local0 16) (= sel_136 1) else (self sel_144: 1))
			)
			(4
				(= sel_65 sAfterQuestions)
				(self sel_111:)
			)
		)
	)
)

(instance sAfterQuestions of Script
	(properties
		sel_20 {sAfterQuestions}
	)
	
	(method (sel_144 theSel_29 &tmp [temp0 100])
		(switch (= sel_29 theSel_29)
			(0
				(cond 
					(
						(and
							(gEgo sel_238: 31)
							(gEgo sel_238: 26)
							(gEgo sel_238: 27)
							(gEgo sel_238: 10)
							local4
							local5
							(gEgo sel_238: 11)
						)
						(= local3 2)
					)
					(
						(and
							(gEgo sel_238: 31)
							(gEgo sel_238: 26)
							(gEgo sel_238: 27)
							(gEgo sel_238: 10)
							local4
						)
						(= local3 1)
					)
					(local5 (= local3 4))
					((gEgo sel_238: 11) (= local3 10))
					(else (= local3 3))
				)
				(cond 
					(
						(and
							(gEgo sel_238: 31)
							(gEgo sel_238: 26)
							(gEgo sel_238: 27)
							(gEgo sel_238: 10)
							local4
							local5
							(gEgo sel_238: 11)
						)
						(= global126 1)
					)
					(
						(and
							(gEgo sel_238: 31)
							(gEgo sel_238: 26)
							(gEgo sel_238: 27)
							(gEgo sel_238: 10)
							local4
						)
						(= global126 4)
					)
					(local5 (= global126 2))
					(else (= global126 3))
				)
				(if (or (== local3 1) (== local3 2))
					(tut sel_110:)
					(gLb2Messager sel_295: 7 0 0 0 self)
				else
					(self sel_144: 3)
				)
			)
			(1
				(tut sel_312: MoveTo -10 113 self)
			)
			(2
				(gLb2Messager sel_295: 7 0 9 0 self)
			)
			(3
				(gLb2Messager sel_295: 3 0 local3 0 self)
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
						(= sel_137 4)
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
				(= sel_137 4)
			)
			(8
				(paper sel_110: sel_102:)
				(headline
					sel_110:
					sel_3: (if (proc999_5 global126 2 4) 2 else global126)
					sel_102:
				)
				(global2 sel_417: 780)
				(gSel_561 sel_119: 102)
				(= sel_136 2)
				(gSel_608 sel_170: 0 12 30 1)
			)
			(9
				(gSel_608 sel_40: 760 sel_99: 1 sel_3: 1 sel_39:)
				(paper sel_216:)
				(paper sel_161: End self)
			)
			(10
				(global2 sel_417: 760 100)
				(paper sel_102:)
				(= sel_136 1)
			)
			(11
				(headline sel_216:)
				(= sel_137 4)
			)
			(12
				(global2
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
		sel_1 -60
		sel_0 113
		sel_2 753
	)
)

(instance reporterHeads of Prop
	(properties
		sel_20 {reporterHeads}
		sel_1 61
		sel_0 73
		sel_2 752
		sel_3 1
		sel_14 16384
	)
)

(instance paper of Prop
	(properties
		sel_20 {paper}
		sel_1 154
		sel_0 96
		sel_2 760
	)
)

(instance r_arm of Prop
	(properties
		sel_20 {r\_arm}
		sel_1 255
		sel_0 91
		sel_2 752
		sel_3 5
	)
)

(instance l_arm of Prop
	(properties
		sel_20 {l\_arm}
		sel_1 280
		sel_0 90
		sel_2 752
		sel_3 6
	)
)

(instance reporters of View
	(properties
		sel_20 {reporters}
		sel_1 62
		sel_0 72
		sel_2 752
	)
)

(instance headline of View
	(properties
		sel_20 {headline}
		sel_1 33
		sel_0 59
		sel_2 760
	)
)

(instance Coroner of Talker
	(properties
		sel_20 {Coroner}
		sel_1 0
		sel_0 0
		sel_2 1750
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 10
		sel_550 10
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super
			sel_110: coronerBust coronerEyes coronerMouth &rest
		)
	)
)

(instance coronerBust of Prop
	(properties
		sel_20 {coronerBust}
		sel_2 1750
		sel_3 1
	)
)

(instance coronerEyes of Prop
	(properties
		sel_20 {coronerEyes}
		sel_6 77
		sel_7 263
		sel_2 1750
		sel_3 2
	)
)

(instance coronerMouth of Prop
	(properties
		sel_20 {coronerMouth}
		sel_6 80
		sel_7 264
		sel_2 1750
	)
)
