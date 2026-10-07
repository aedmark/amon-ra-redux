;;; Sierra Script 1.0 - (do not remove this comment)
(script# 340)
(include sci.sh)
(use Main)
(use LBRoom)
(use RotundaRgn)
(use Messager)
(use RTRandCycle)
(use View)
(use Obj)

(public
	testRoom 0
)

(local
	local0
	theGLb2Messager
)
(procedure (localproc_08b8 param1 param2 param3)
	(switch param1
		(1782
			(param2 sel_7: 42 sel_6: 16)
			(param3 sel_7: 44 sel_6: 29)
		)
		(1791
			(param2 sel_7: 58 sel_6: 17)
			(param3 sel_7: 58 sel_6: 28)
		)
		(1786
			(param2 sel_7: 44 sel_6: 16)
			(param3 sel_7: 42 sel_6: 24)
		)
		(1785
			(param2 sel_7: 26 sel_6: 16)
			(param3 sel_7: 26 sel_6: 26)
		)
		(1793
			(param2 sel_7: 33 sel_6: 15)
			(param3 sel_7: 31 sel_6: 23)
		)
		(1790
			(param2 sel_7: 42 sel_6: 14)
			(param3 sel_7: 33 sel_6: 23)
		)
		(1788
			(param2 sel_7: 45 sel_6: 17)
			(param3 sel_7: 44 sel_6: 27)
		)
		(1783
			(param2 sel_7: 63 sel_6: 17)
			(param3 sel_7: 63 sel_6: 31)
		)
		(1784
			(param2 sel_7: 27 sel_6: 20)
			(param3 sel_7: 25 sel_6: 27)
		)
		(1792
			(param2 sel_7: 63 sel_6: 19)
			(param3 sel_7: 66 sel_6: 31)
		)
		(1787
			(param2 sel_7: 63 sel_6: 18)
			(param3 sel_7: 61 sel_6: 28)
		)
		(1781
			(param2 sel_7: 81 sel_6: 20)
			(param3 sel_7: 78 sel_6: 27)
		)
	)
)

(instance testRoom of LBRoom
	(properties
		sel_20 {testRoom}
		sel_408 780
		sel_28 9
	)
	
	(method (sel_110)
		(self sel_414: 93)
		(super sel_110:)
		(gIconBar sel_233:)
		(= theGLb2Messager gLb2Messager)
		(= gLb2Messager convMessager)
		(partyLaura sel_317:)
		(switch global128
			(0
				(= local0 13)
				((ScriptID 21 0) sel_57: 266)
				(partyPerson1
					sel_2: 1782
					sel_153: 92 29
					sel_63: 3
					sel_317:
				)
				(partyPerson2 sel_2: 1791 sel_153: 180 19 sel_317:)
				(partyPerson3
					sel_2: 1786
					sel_153: 238 42
					sel_63: 3
					sel_317:
				)
				(partyPerson4
					sel_2: 1785
					sel_153: 168 49
					sel_63: 3
					sel_317:
				)
				(partyPerson5
					sel_2: 1790
					sel_153: 60 46
					sel_63: 9
					sel_317:
				)
			)
			(1
				(= local0 14)
				(partyPerson1
					sel_2: 1782
					sel_153: 92 29
					sel_63: 3
					sel_317:
				)
				(partyPerson2
					sel_2: 1791
					sel_153: 135 26
					sel_63: 1
					sel_317:
				)
				(partyPerson3
					sel_2: 1786
					sel_153: 181 38
					sel_63: 2
					sel_317:
				)
				(partyPerson4
					sel_2: 1790
					sel_153: 60 46
					sel_63: 9
					sel_317:
				)
			)
			(2
				(= local0 4)
				(partyPerson1
					sel_2: 1788
					sel_153: 192 20
					sel_63: 3
					sel_317:
				)
				(partyPerson2
					sel_2: 1793
					sel_153: 116 56
					sel_63: 9
					sel_317:
				)
			)
			(3
				((ScriptID 22 0) sel_57: 16)
				(= local0 5)
				(partyPerson1 sel_2: 1788 sel_153: 104 28 sel_317:)
				(partyPerson2
					sel_2: 1783
					sel_153: 159 26
					sel_63: 2
					sel_317:
				)
				((ScriptID 21 0) sel_57: 271)
			)
			(4
				(= local0 8)
				(partyPerson1 sel_2: 1784 sel_153: 212 36 sel_317:)
				(partyPerson2
					sel_2: 1791
					sel_153: 99 32
					sel_63: 2
					sel_317:
				)
			)
			(5
				(= local0 10)
				(partyPerson1 sel_2: 1784 sel_153: 212 36 sel_317:)
				(partyPerson2
					sel_2: 1790
					sel_153: 133 41
					sel_63: 2
					sel_317:
				)
			)
			(6
				(= local0 1)
				(partyPerson1 sel_2: 1785 sel_153: 201 49 sel_317:)
				(partyPerson2
					sel_2: 1790
					sel_153: 133 41
					sel_63: 2
					sel_317:
				)
			)
			(7
				(= local0 2)
				(partyPerson1
					sel_2: 1786
					sel_153: 194 42
					sel_63: 2
					sel_317:
				)
				(partyPerson2
					sel_2: 1793
					sel_153: 132 53
					sel_63: 1
					sel_317:
				)
			)
			(8
				(= local0 3)
				(partyPerson1 sel_2: 1788 sel_153: 125 35 sel_317:)
				(partyPerson2 sel_2: 1790 sel_153: 230 56 sel_317:)
			)
			(9
				(= local0 11)
				(partyPerson1 sel_2: 1791 sel_153: 122 40 sel_317:)
				(partyPerson2
					sel_2: 1783
					sel_153: 187 31
					sel_63: 4
					sel_317:
				)
				(partyPerson3 sel_2: 1793 sel_153: 54 68 sel_317:)
			)
			(10
				(= local0 9)
				(partyPerson1
					sel_2: 1784
					sel_153: 243 41
					sel_63: 4
					sel_317:
				)
				(partyPerson2 sel_2: 1792 sel_153: 142 35 sel_317:)
				(partyPerson3
					sel_2: 1793
					sel_153: 103 68
					sel_63: 0
					sel_317:
				)
			)
			(11
				(= local0 6)
				(partyPerson1 sel_2: 1782 sel_153: 103 39 sel_317:)
				(partyPerson2
					sel_2: 1785
					sel_153: 197 68
					sel_63: 0
					sel_317:
				)
			)
			(12
				((ScriptID 22 0) sel_57: 2)
				(= local0 7)
				(partyPerson1 sel_2: 1782 sel_153: 101 39 sel_317:)
				(partyPerson2
					sel_2: 1783
					sel_153: 163 25
					sel_63: 0
					sel_317:
				)
			)
			(13
				(= local0 12)
				(partyPerson1 sel_2: 1787 sel_153: 94 40 sel_317:)
				(partyPerson2 sel_2: 1785 sel_153: 181 57 sel_317:)
			)
		)
		(self sel_146: sConv)
	)
	
	(method (sel_111)
		(= gLb2Messager theGLb2Messager)
		(super sel_111:)
	)
	
	(method (sel_399)
		(gIconBar sel_177:)
		(gSel_608 sel_170: 127 5 5 0)
		(super sel_399: &rest)
	)
)

(instance sConv of Script
	(properties
		sel_20 {sConv}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 2))
			(1
				(gLb2Messager sel_295: local0 0 0 0 self)
			)
			(2
				(++ global128)
				(global2 sel_399: (RotundaRgn sel_667?))
			)
		)
	)
)

(instance partyLaura of View
	(properties
		sel_20 {partyLaura}
		sel_1 -48
		sel_0 30
		sel_2 1781
		sel_3 1
	)
)

(instance partyPerson1 of View
	(properties
		sel_20 {partyPerson1}
		sel_3 1
	)
)

(instance partyPerson2 of View
	(properties
		sel_20 {partyPerson2}
		sel_3 1
	)
)

(instance partyPerson3 of View
	(properties
		sel_20 {partyPerson3}
		sel_3 1
	)
)

(instance partyPerson4 of View
	(properties
		sel_20 {partyPerson4}
		sel_3 1
	)
)

(instance partyPerson5 of View
	(properties
		sel_20 {partyPerson5}
		sel_3 1
	)
)

(instance tkrParty1 of Talker
	(properties
		sel_20 {tkrParty1}
		sel_3 3
		sel_291 0
		sel_537 250
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_2 (partyPerson1 sel_2?))
		(= sel_1 (partyPerson1 sel_1?))
		(= sel_0 (partyPerson1 sel_0?))
		(tkrEyes1 sel_2: sel_2 sel_3: 2)
		(tkrMouth1 sel_2: sel_2)
		(localproc_08b8 sel_2 tkrEyes1 tkrMouth1)
		(= sel_549 (* (- sel_1 10) -1))
		(= sel_550 (- 120 sel_0))
		(= sel_30 gSel_30)
		(super sel_110: 0 tkrEyes1 tkrMouth1)
	)
)

(instance tkrEyes1 of Prop
	(properties
		sel_20 {tkrEyes1}
	)
)

(instance tkrMouth1 of Prop
	(properties
		sel_20 {tkrMouth1}
	)
)

(instance tkrParty2 of Talker
	(properties
		sel_20 {tkrParty2}
		sel_3 3
		sel_291 0
		sel_537 250
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_2 (partyPerson2 sel_2?))
		(= sel_1 (partyPerson2 sel_1?))
		(= sel_0 (partyPerson2 sel_0?))
		(tkrEyes2 sel_2: sel_2 sel_3: 2)
		(tkrMouth2 sel_2: sel_2)
		(localproc_08b8 sel_2 tkrEyes2 tkrMouth2)
		(= sel_549 (* (- sel_1 10) -1))
		(= sel_550 (- 120 sel_0))
		(= sel_30 gSel_30)
		(super sel_110: 0 tkrEyes2 tkrMouth2)
	)
)

(instance tkrEyes2 of Prop
	(properties
		sel_20 {tkrEyes2}
	)
)

(instance tkrMouth2 of Prop
	(properties
		sel_20 {tkrMouth2}
	)
)

(instance tkrParty3 of Talker
	(properties
		sel_20 {tkrParty3}
		sel_3 3
		sel_291 0
		sel_537 250
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_2 (partyPerson3 sel_2?))
		(= sel_1 (partyPerson3 sel_1?))
		(= sel_0 (partyPerson3 sel_0?))
		(tkrEyes3 sel_2: sel_2 sel_3: 2)
		(tkrMouth3 sel_2: sel_2)
		(localproc_08b8 sel_2 tkrEyes3 tkrMouth3)
		(= sel_549 (* (- sel_1 10) -1))
		(= sel_550 (- 120 sel_0))
		(= sel_30 gSel_30)
		(super sel_110: 0 tkrEyes3 tkrMouth3)
	)
)

(instance tkrEyes3 of Prop
	(properties
		sel_20 {tkrEyes3}
	)
)

(instance tkrMouth3 of Prop
	(properties
		sel_20 {tkrMouth3}
	)
)

(instance tkrParty4 of Talker
	(properties
		sel_20 {tkrParty4}
		sel_3 3
		sel_291 0
		sel_537 250
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_2 (partyPerson4 sel_2?))
		(= sel_1 (partyPerson4 sel_1?))
		(= sel_0 (partyPerson4 sel_0?))
		(tkrEyes4 sel_2: sel_2 sel_3: 2)
		(tkrMouth4 sel_2: sel_2)
		(localproc_08b8 sel_2 tkrEyes4 tkrMouth4)
		(= sel_549 (* (- sel_1 10) -1))
		(= sel_550 (- 120 sel_0))
		(= sel_30 gSel_30)
		(super sel_110: 0 tkrEyes4 tkrMouth4)
	)
)

(instance tkrEyes4 of Prop
	(properties
		sel_20 {tkrEyes4}
	)
)

(instance tkrMouth4 of Prop
	(properties
		sel_20 {tkrMouth4}
	)
)

(instance tkrParty5 of Talker
	(properties
		sel_20 {tkrParty5}
		sel_3 3
		sel_291 0
		sel_537 250
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_2 (partyPerson5 sel_2?))
		(= sel_1 (partyPerson5 sel_1?))
		(= sel_0 (partyPerson5 sel_0?))
		(tkrEyes5 sel_2: sel_2 sel_3: 2)
		(tkrMouth5 sel_2: sel_2)
		(localproc_08b8 sel_2 tkrEyes5 tkrMouth5)
		(= sel_549 (* (- sel_1 10) -1))
		(= sel_550 (- 120 sel_0))
		(= sel_30 gSel_30)
		(super sel_110: 0 tkrEyes5 tkrMouth5)
	)
)

(instance tkrEyes5 of Prop
	(properties
		sel_20 {tkrEyes5}
	)
)

(instance tkrMouth5 of Prop
	(properties
		sel_20 {tkrMouth5}
	)
)

(instance Laura of Talker
	(properties
		sel_20 {Laura}
		sel_1 -48
		sel_0 30
		sel_2 1781
		sel_3 3
		sel_537 250
		sel_26 15
	)
	
	(method (sel_110)
		(tkrEyesL sel_2: sel_2 sel_3: 2)
		(tkrMouthL sel_2: sel_2)
		(localproc_08b8 sel_2 tkrEyesL tkrMouthL)
		(= sel_549 58)
		(= sel_550 (- 120 sel_0))
		(= sel_30 gSel_30)
		(super sel_110: 0 tkrEyesL tkrMouthL)
	)
)

(instance tkrEyesL of Prop
	(properties
		sel_20 {tkrEyesL}
	)
)

(instance tkrMouthL of Prop
	(properties
		sel_20 {tkrMouthL}
	)
)

(instance convMessager of Messager
	(properties
		sel_20 {convMessager}
	)
	
	(method (sel_297 param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(29 tkrParty1)
					(2 Laura)
					(25 tkrParty2)
					(19 tkrParty1)
					(10 tkrParty1)
					(27
						(if (== global128 9) tkrParty1 else tkrParty2)
					)
					(12 tkrParty1)
					(9 tkrParty2)
					(11
						(if (== global128 7) tkrParty1 else tkrParty3)
					)
					(28
						(switch global128
							(0 tkrParty4)
							(6 tkrParty1)
							(9 tkrParty3)
							(10 tkrParty3)
							(else  tkrParty2)
						)
					)
					(6
						(switch global128
							(0 tkrParty5)
							(1 tkrParty4)
							(else  tkrParty2)
						)
					)
				)
			)
			(return)
		else
			(super sel_297: param1)
		)
	)
)
