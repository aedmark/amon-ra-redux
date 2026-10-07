;;; Sierra Script 1.0 - (do not remove this comment)
(script# 950)
(include sci.sh)
(use Main)
(use PApproach)
(use Obj)


(class CueObj of Script
	(properties
		sel_20 {CueObj}
		sel_42 0
		sel_29 -1
		sel_134 0
		sel_135 0
		sel_136 0
		sel_137 0
		sel_138 0
		sel_139 0
		sel_140 0
		sel_141 0
		sel_142 0
		sel_143 0
		sel_65 0
		sel_298 0
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(1
				(gEgo
					sel_253:
						(GetAngle
							(gEgo sel_1?)
							(gEgo sel_0?)
							(sel_42 sel_1?)
							(sel_42 sel_0?)
						)
						self
				)
				(gTheDoits sel_118: self)
			)
			(2 (= sel_136 3))
			(3
				(gTheDoits sel_81: self)
				(if
					(not
						(if (and sel_42 (IsObject (sel_42 sel_299?)))
							((sel_42 sel_299?) sel_300: sel_298)
						)
					)
					(sel_42 sel_300: sel_298)
				)
				(= sel_29 0)
			)
		)
	)
)

(class Feature of Obj
	(properties
		sel_20 {Feature}
		sel_1 0
		sel_0 0
		sel_82 0
		sel_55 0
		sel_213 0
		sel_214 -1
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_301 26505
		sel_299 0
		sel_302 26505
		sel_303 0
		sel_304 0
		sel_305 0
		sel_306 0
	)
	
	(method (sel_110 param1)
		(self sel_307: (if argc param1 else 0))
		(if (self sel_116: 5)
			(gSel_561 sel_118: self)
		else
			(gSel_562 sel_118: self)
		)
	)
	
	(method (sel_111)
		(if sel_299 (sel_299 sel_111:) (= sel_299 0))
		(if (IsObject sel_302)
			(sel_302 sel_111:)
			(= sel_302 0)
		)
		(gSel_562 sel_81: self)
		(super sel_111:)
	)
	
	(method (sel_307 param1)
		(cond 
			((and argc param1) (self sel_96: param1))
			(gLb2FtrInit (self sel_96: gLb2FtrInit))
		)
	)
	
	(method (sel_133 param1 &tmp temp0)
		(cond 
			((param1 sel_73?) (return 1))
			(
				(and
					(& (param1 sel_31?) $4000)
					(self sel_218: param1)
					(self sel_310:)
				)
				(CueObj
					sel_29: 0
					sel_136: 0
					sel_42: self
					sel_298: (param1 sel_37?)
				)
				(param1 sel_73: 1)
				(if
					(and
						(gUser sel_237:)
						(>
							(GetDistance
								(gEgo sel_1?)
								(gEgo sel_0?)
								sel_303
								sel_304
							)
							sel_305
						)
						gLb2ApproachCode
						(& sel_306 (gLb2ApproachCode sel_57: (param1 sel_37?)))
					)
					(gEgo
						sel_312: PApproach sel_303 (+ (gEgo sel_82?) sel_304) sel_305 CueObj
					)
				else
					(gEgo sel_312: 0)
					(if (self sel_309:) (CueObj sel_144: 3))
				)
			)
		)
		(return (param1 sel_73?))
	)
	
	(method (sel_300 param1 &tmp temp0 temp1)
		(= temp0 (if gLb2DoVerbCode else dftDoVerb))
		(if (== sel_214 -1) (= sel_214 gSel_40))
		(if
			(and
				global90
				(Message msgGET sel_214 sel_213 param1 0 1)
			)
			(gLb2Messager sel_295: sel_213 param1 0 0 0 sel_214)
		else
			(temp0 sel_57: param1 self)
		)
	)
	
	(method (sel_308 &tmp temp0)
		(gEgo sel_312: 0)
		(CueObj sel_42: self sel_29: 0 sel_136: 0 sel_145:)
	)
	
	(method (sel_309 param1 &tmp temp0 temp1)
		(= temp0 (if argc param1 else gEgo))
		(if
			(>
				(= temp1
					(Abs
						(-
							(GetAngle (temp0 sel_1?) (temp0 sel_0?) sel_1 sel_0)
							(temp0 sel_55?)
						)
					)
				)
				180
			)
			(= temp1 (- 360 temp1))
		)
		(return
			(if (<= temp1 sel_301)
				(return 1)
			else
				(if (!= sel_301 26505) (self sel_308:))
				(return 0)
			)
		)
	)
	
	(method (sel_310)
		(return 1)
	)
	
	(method (sel_218 param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 sel_1?))
			(= temp1 (param1 sel_0?))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond 
				((IsObject sel_302) (AvoidPath temp0 temp1 sel_302))
				(
					(or
						(not (if (or sel_7 sel_9 sel_6) else sel_8))
						(and
							(<= sel_7 temp0)
							(<= temp0 sel_9)
							(<= sel_6 temp1)
							(<= temp1 sel_8)
						)
					)
					(if (!= sel_302 26505)
						(& sel_302 (OnControl 4 temp0 temp1))
					else
						1
					)
				)
			)
		)
	)
	
	(method (sel_311 param1 &tmp temp0 temp1)
		(= sel_306 0)
		(if (and argc gLb2ApproachCode [param1 0])
			(= temp0 0)
			(while (< temp0 argc)
				(= temp1 (gLb2ApproachCode sel_57: [param1 temp0]))
				(self sel_306: (| (self sel_306?) temp1))
				(++ temp0)
			)
		)
	)
)

(instance dftDoVerb of Code
	(properties
		sel_20 {dftDoVerb}
	)
	
	(method (sel_57)
		(return 1)
	)
)

(class Actions of Code
	(properties
		sel_20 {Actions}
	)
	
	(method (sel_300)
		(return 0)
	)
)
