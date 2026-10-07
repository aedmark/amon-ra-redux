;;; Sierra Script 1.0 - (do not remove this comment)
(script# 710)
(include sci.sh)
(use Main)
(use LBRoom)
(use RTRandCycle)
(use PolyPath)
(use n958)
(use StopWalk)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm710 0
	Rameses_b 2
	Rameses_a 27
)

(instance rm710 of LBRoom
	(properties
		sel_20 {rm710}
		sel_408 710
		sel_412 700
	)
	
	(method (sel_110)
		(global2 sel_259: (List sel_109:))
		((ScriptID 2710 0) sel_57: (global2 sel_259?))
		(gEgo
			sel_110:
			sel_585: 831
			sel_584: 1
			sel_103: 1
			sel_104: 110
			sel_105: 110
			sel_63: 10
			sel_153: 63 155
		)
		(proc958_0 132 710 712 713 714 715 716)
		(proc958_0 128 710 714 717 716 994)
		(Load rsMESSAGE 710)
		(Load rsFONT 69)
		(super sel_110:)
		(WrapMusic sel_110: 1 1710 1712 1713)
		(wrapMusic2 sel_110: 1 714 715 716)
		(sunnie1 sel_110: sel_161: Fwd)
		(sunnie2 sel_110: sel_161: Fwd)
		(tut sel_110: sel_161: Walk sel_155: 0)
		(rameses sel_110: sel_161: StopWalk -1)
		(bugsWithMeat sel_110: sel_155: 0 sel_161: Walk)
		(ferret sel_110: sel_155: 5 sel_161: Walk)
		(global2 sel_146: sEnterRoom)
	)
	
	(method (sel_111)
		(DisposeScript 2710)
		(super sel_111: &rest)
	)
)

(instance sEnterRoom of Script
	(properties
		sel_20 {sEnterRoom}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				((ScriptID 22 0) sel_57: 1)
				(= sel_139 180)
			)
			(1
				(gEgo sel_312: PolyPath 96 169 self)
			)
			(2
				(gEgo sel_63: -1)
				(gLb2Messager sel_295: 1 0 0 1)
				(= sel_136 1)
			)
			(3
				(sunnie1 sel_161: End sunnie1)
				(sunnie2 sel_161: End sunnie2)
			)
			(4)
			(5
				(WrapMusic sel_111:)
				(wrapMusic2 sel_111: 1)
				(proc958_0 132 636 637)
				(proc958_0 128 635 632)
				(Load rsPIC 716)
				(= sel_139 60)
			)
			(6
				(gEgo
					sel_2: 716
					sel_155: 4
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
				(sunnie1 sel_313:)
				(sunnie2 sel_313:)
			)
			(7
				(tut sel_312: PolyPath 107 171 tut)
				(= sel_136 35)
			)
			(8
				(gLb2Messager sel_295: 1 0 0 2)
				(sFXBeetles sel_39: 0 sel_170: 127 25 10 0)
				(= sel_136 1)
			)
			(9
				(bugsWithMeat sel_312: MoveTo 110 188)
				(= sel_139 240)
				(rameses sel_312: PolyPath 76 171 self)
			)
			(10
				(ferret sel_312: MoveTo 133 185)
				(sFXFerret sel_39:)
				(sFXBeetles sel_170:)
			)
			(11
				(rameses sel_155: 3 sel_156: 2 sel_161: CT 6 1 self)
			)
			(12
				(rameses
					sel_2: 716
					sel_155: 0
					sel_156: 0
					sel_161: End self
				)
			)
			(13
				(tut sel_313:)
				(rameses sel_313:)
				(= sel_139 30)
			)
			(14
				(gGameMusic2 sel_40: 711 sel_99: 1 sel_3: -1 sel_39:)
				(gSel_561 sel_119: 102)
				(global2 sel_417: 716 9 sel_408: 716)
				(= sel_136 1)
			)
			(15 (= sel_139 120))
			(16
				(gLb2Messager sel_295: 1 0 1)
				(= sel_136 1)
			)
			(17 (= sel_139 120))
			(18
				(gSel_561 sel_119: 216)
				(gEgo sel_111:)
				(tut sel_111:)
				(rameses sel_111:)
				(sunnie1 sel_156: 0)
				(sunnie2 sel_156: 0)
				(global2 sel_417: 710 9 sel_408: 716)
				(= sel_139 120)
			)
			(19
				(global2 sel_399: 715)
				(self sel_111:)
			)
		)
	)
)

(instance tut of Actor
	(properties
		sel_20 {tut}
		sel_1 335
		sel_0 178
		sel_2 717
		sel_14 16385
	)
	
	(method (sel_145)
		(gLb2Messager sel_295: 1 0 0 3)
		(self sel_2: 716 sel_155: 1 sel_156: 0 sel_161: End)
	)
)

(instance rameses of Actor
	(properties
		sel_20 {rameses}
		sel_1 335
		sel_0 178
		sel_2 717
		sel_3 1
		sel_14 16385
	)
)

(instance bugsWithMeat of Actor
	(properties
		sel_20 {bugsWithMeat}
		sel_1 -18
		sel_0 168
		sel_2 635
		sel_60 10
		sel_14 16400
	)
)

(instance ferret of Actor
	(properties
		sel_20 {ferret}
		sel_1 -5
		sel_0 171
		sel_2 632
		sel_3 5
		sel_14 16384
		sel_51 4
	)
)

(instance sunnie1 of Prop
	(properties
		sel_20 {sunnie1}
		sel_1 305
		sel_0 184
		sel_2 710
		sel_3 1
		sel_14 16385
		sel_244 12
	)
	
	(method (sel_145)
		(self
			sel_2: 716
			sel_155: 2
			sel_156: 0
			sel_161: End sEnterRoom
		)
	)
)

(instance sunnie2 of Prop
	(properties
		sel_20 {sunnie2}
		sel_1 282
		sel_0 174
		sel_2 714
		sel_3 2
		sel_14 16385
		sel_244 12
	)
	
	(method (sel_145)
		(self
			sel_2: 716
			sel_155: 3
			sel_156: 0
			sel_161: End sEnterRoom
		)
	)
)

(instance Rameses_a of Talker
	(properties
		sel_20 {Rameses}
		sel_1 66
		sel_0 44
		sel_2 1716
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 20
		sel_550 60
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super
			sel_110: ramesesBust ramesesEyes ramesesMouth &rest
		)
	)
)

(instance ramesesBust of Prop
	(properties
		sel_20 {ramesesBust}
		sel_2 1716
		sel_3 1
	)
)

(instance ramesesEyes of Prop
	(properties
		sel_20 {ramesesEyes}
		sel_6 20
		sel_7 12
		sel_2 1716
		sel_3 2
	)
)

(instance ramesesMouth of Prop
	(properties
		sel_20 {ramesesMouth}
		sel_6 32
		sel_7 22
		sel_2 1716
	)
)

(instance Rameses_b of Talker
	(properties
		sel_20 {Rameses}
		sel_1 121
		sel_0 54
		sel_2 1717
		sel_3 3
		sel_537 150
		sel_26 15
		sel_550 50
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: lauraBust lauraEyes lauraMouth &rest)
	)
)

(instance lauraBust of Prop
	(properties
		sel_20 {lauraBust}
		sel_2 1717
		sel_3 1
	)
)

(instance lauraEyes of Prop
	(properties
		sel_20 {lauraEyes}
		sel_6 20
		sel_7 15
		sel_2 1717
		sel_3 2
	)
)

(instance lauraMouth of Prop
	(properties
		sel_20 {lauraMouth}
		sel_6 28
		sel_7 15
		sel_2 1717
	)
)

(instance sFXBeetles of Sound
	(properties
		sel_20 {sFXBeetles}
		sel_99 1
		sel_40 636
		sel_3 -1
	)
)

(instance sFXFerret of Sound
	(properties
		sel_20 {sFXFerret}
		sel_99 1
		sel_40 637
	)
)

(instance wrapMusic2 of WrapMusic
	(properties
		sel_20 {wrapMusic2}
	)
	
	(method (sel_110)
		(= sel_608 sWrap)
		(super sel_110: &rest)
	)
)

(instance sWrap of Sound
	(properties
		sel_20 {sWrap}
	)
)
